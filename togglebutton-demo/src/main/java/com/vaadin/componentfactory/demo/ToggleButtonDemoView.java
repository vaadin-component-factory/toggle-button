package com.vaadin.componentfactory.demo;

import com.vaadin.componentfactory.ToggleButton;
import com.vaadin.componentfactory.ToggleButton.LabelPosition;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

@Route("togglebutton")
public class ToggleButtonDemoView extends VerticalLayout {

    private static final String LUMO = "Lumo";
    private static final String AURA = "Aura";
    private static final String UNSTYLED = "Unstyled";

    public ToggleButtonDemoView() {
        add(new H3("Toggle Button Demo"));
        add(new Span(
                "Use the theme selector to switch between Lumo, Aura, and Unstyled (base) themes."));

        add(createThemeChanger());

        Div grid = new Div();
        grid.getStyle()
                .set("display", "grid")
                .set("grid-template-columns", "1fr 1fr")
                .set("gap", "16px")
                .set("max-width", "600px");

        grid.add(createPanel("Light", false));
        grid.add(createPanel("Dark", true));

        add(grid);

        setPadding(true);
        setSpacing(true);
    }

    /**
     * Theme switcher using dynamic stylesheet loading with {@link Registration}
     * to apply and un-apply Lumo / Aura stylesheets at runtime.
     */
    private Select<String> createThemeChanger() {
        Select<String> select = new Select<>();
        select.setLabel("Theme");
        select.setItems(UNSTYLED, LUMO, AURA);
        select.setValue(UNSTYLED);

        select.addValueChangeListener(event -> switchTheme(
                event.getSource().getUI().orElse(UI.getCurrent()),
                event.getValue()));

        return select;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        UI ui = attachEvent.getUI();
        Registration registration = ComponentUtil.getData(ui, Registration.class);
        if (registration == null) {
            switchTheme(ui, UNSTYLED);
        }
    }

    private void switchTheme(UI ui, String theme) {
        Registration registration = ComponentUtil.getData(ui, Registration.class);
        if (registration != null) {
            registration.remove();
        }

        String styleSheet = switch (theme) {
            case LUMO -> "lumo/lumo.css";
            case AURA -> "aura/aura.css";
            default -> null;
        };

        if (styleSheet != null) {
            registration = ui.getPage().addStyleSheet(styleSheet);
        } else {
            registration = null;
        }

        ComponentUtil.setData(ui, Registration.class, registration);
    }

    private Div createPanel(String title, boolean dark) {
        Div panel = new Div();

        String bg = dark ? "#1a1a1a" : "#ffffff";
        String textColor = dark ? "#e0e0e0" : "#1a1a1a";
        String borderColor = dark ? "#444" : "#e0e0e0";

        panel.getStyle()
                .set("padding", "20px")
                .set("border-radius", "12px")
                .set("border", "1px solid " + borderColor)
                .set("background-color", bg)
                .set("color", textColor);

        panel.getStyle()
                .set("--vaadin-checkbox-label-color", textColor)
                .set("--vaadin-input-field-label-color", textColor);

        if (dark) {
            panel.getStyle()
                    .set("--lumo-disabled-text-color", "rgba(224, 224, 224, 0.4)")
                    .set("--vaadin-input-field-label-color", "#e0e0e0")
                    .set("--vaadin-text-color", "#e0e0e0")
                    .set("--vaadin-text-color-secondary", "rgba(224, 224, 224, 0.7)")
                    .set("--vaadin-input-field-error-color", "#ff8a80")
                    .set("--vaadin-input-field-required-indicator-color", "rgba(224, 224, 224, 0.7)");
        }

        H4 heading = new H4(title);
        heading.getStyle()
                .set("margin", "0 0 12px 0")
                .set("font-size", "14px")
                .set("color", textColor);
        panel.add(heading);

        // ── Label End (default) ────────────────────────────────────────
        String suffix = dark ? "dark" : "light";

        H4 endHeading = new H4("Label End");
        endHeading.getStyle()
                .set("margin", "0 0 12px 0")
                .set("font-size", "14px")
                .set("color", textColor);
        panel.add(endHeading);

        ToggleButton off = new ToggleButton("Off state");
        off.setId("toggle-end-off-" + suffix);
        panel.add(off);
        panel.add(spacer());

        ToggleButton on = new ToggleButton("On state", true);
        on.setId("toggle-end-on-" + suffix);
        panel.add(on);
        panel.add(spacer());

        ToggleButton disabled = new ToggleButton("Disabled");
        disabled.setEnabled(false);
        disabled.setId("toggle-end-disabled-" + suffix);
        panel.add(disabled);
        panel.add(spacer());

        ToggleButton disabledOn = new ToggleButton("Disabled on", true);
        disabledOn.setEnabled(false);
        disabledOn.setId("toggle-end-disabled-on-" + suffix);
        panel.add(disabledOn);
        panel.add(spacer());

        ToggleButton endHelper = new ToggleButton("With helper");
        endHelper.setHelperText("Descriptive helper text");
        endHelper.setId("toggle-end-helper-" + suffix);
        panel.add(endHelper);
        panel.add(spacer());

        ToggleButton endError = new ToggleButton("With error");
        endError.setHelperText("Helper text");
        endError.setErrorMessage("This field is required");
        endError.setInvalid(true);
        endError.setId("toggle-end-error-" + suffix);
        panel.add(endError);

        // ── All non-END label positions ────────────────────────────────
        for (LabelPosition pos : new LabelPosition[]{
                LabelPosition.START,
                LabelPosition.TOP,
                LabelPosition.BOTTOM}) {

            panel.add(spacer());

            String posName = pos.name().charAt(0) + pos.name().substring(1).toLowerCase();
            String posKey = pos.name().toLowerCase();

            H4 posHeading = new H4("Label " + posName);
            posHeading.getStyle()
                    .set("margin", "12px 0 12px 0")
                    .set("font-size", "14px")
                    .set("color", textColor);
            panel.add(posHeading);

            ToggleButton posOff = new ToggleButton("Off state");
            posOff.setLabelPosition(pos);
            posOff.setId("toggle-" + posKey + "-off-" + suffix);
            panel.add(posOff);
            panel.add(spacer());

            ToggleButton posOn = new ToggleButton("On state", true);
            posOn.setLabelPosition(pos);
            posOn.setId("toggle-" + posKey + "-on-" + suffix);
            panel.add(posOn);
            panel.add(spacer());

            // ── With helper text ───────────────────────────────────────
            ToggleButton withHelper = new ToggleButton("With helper");
            withHelper.setLabelPosition(pos);
            withHelper.setHelperText("Descriptive helper text");
            withHelper.setId("toggle-" + posKey + "-helper-" + suffix);
            panel.add(withHelper);
            panel.add(spacer());

            // ── With error message (invalid state) ────────────────────
            ToggleButton withError = new ToggleButton("With error");
            withError.setLabelPosition(pos);
            withError.setHelperText("Helper text");
            withError.setErrorMessage("This field is required");
            withError.setInvalid(true);
            withError.setId("toggle-" + posKey + "-error-" + suffix);
            panel.add(withError);
        }

        panel.add(spacer());

        H4 groupHeading = new H4("CheckboxGroup");
        groupHeading.getStyle()
                .set("margin", "12px 0 12px 0")
                .set("font-size", "14px")
                .set("color", textColor);
        panel.add(groupHeading);

        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("Export data");
        checkboxGroup.setItems("Order ID", "Product name", "Customer", "Status");
        checkboxGroup.select("Order ID", "Customer");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        checkboxGroup.addThemeName(ToggleButton.THEME_NAME);
        checkboxGroup.setId("toggle-checkbox-group-" + suffix);
        panel.add(checkboxGroup);

        return panel;
    }

    private Div spacer() {
        Div spacer = new Div();
        spacer.getStyle().set("height", "8px");
        return spacer;
    }
}
