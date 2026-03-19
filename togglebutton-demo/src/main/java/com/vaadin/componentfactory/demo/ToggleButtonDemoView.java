package com.vaadin.componentfactory.demo;

import com.vaadin.componentfactory.ToggleButton;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
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
        // Ensure we start in unstyled mode (no theme stylesheet loaded)
        Registration registration = ComponentUtil.getData(ui,
                Registration.class);
        if (registration == null) {
            switchTheme(ui, UNSTYLED);
        }
    }

    private void switchTheme(UI ui, String theme) {
        // Remove previous theme stylesheet
        Registration registration = ComponentUtil.getData(ui,
                Registration.class);
        if (registration != null) {
            registration.remove();
        }

        // Add the new theme stylesheet
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

        // Label colors for readability on light/dark backgrounds
        panel.getStyle()
                .set("--vaadin-checkbox-label-color", textColor)
                .set("--vaadin-input-field-label-color", textColor);

        if (dark) {
            // Override theme disabled text colors for dark backgrounds
            panel.getStyle()
                    .set("--lumo-disabled-text-color", "rgba(224, 224, 224, 0.4)")
                    .set("--vaadin-input-field-label-color", "#e0e0e0");
        }

        H4 heading = new H4(title);
        heading.getStyle()
                .set("margin", "0 0 12px 0")
                .set("font-size", "14px")
                .set("color", textColor);
        panel.add(heading);

        panel.add(new ToggleButton("Off state"));
        panel.add(spacer());
        panel.add(new ToggleButton("On state", true));
        panel.add(spacer());

        ToggleButton disabled = new ToggleButton("Disabled");
        disabled.setEnabled(false);
        panel.add(disabled);
        panel.add(spacer());

        ToggleButton disabledOn = new ToggleButton("Disabled on", true);
        disabledOn.setEnabled(false);
        panel.add(disabledOn);

        return panel;
    }

    private Div spacer() {
        Div spacer = new Div();
        spacer.getStyle().set("height", "8px");
        return spacer;
    }
}
