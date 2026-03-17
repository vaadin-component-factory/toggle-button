package com.vaadin.componentfactory.demo;

import com.vaadin.componentfactory.ToggleButton;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("togglebutton")
public class ToggleButtonDemoView extends VerticalLayout {

    public ToggleButtonDemoView() {
        add(new H3("Toggle Button Demo"));
        add(new Span("Showing the toggle button under all six theme combinations."));

        // 3 columns x 2 rows grid
        Div grid = new Div();
        grid.getStyle()
                .set("display", "grid")
                .set("grid-template-columns", "1fr 1fr 1fr")
                .set("gap", "16px")
                .set("max-width", "900px");

        // Row 1: Light mode
        grid.add(createPanel("Lumo Light", false, Theme.LUMO));
        grid.add(createPanel("Aura Light", false, Theme.AURA));
        grid.add(createPanel("Unstyled Light", false, Theme.NONE));

        // Row 2: Dark mode
        grid.add(createPanel("Lumo Dark", true, Theme.LUMO));
        grid.add(createPanel("Aura Dark", true, Theme.AURA));
        grid.add(createPanel("Unstyled Dark", true, Theme.NONE));

        add(grid);

        setPadding(true);
        setSpacing(true);
    }

    private enum Theme { LUMO, AURA, NONE }

    private Div createPanel(String title, boolean dark, Theme theme) {
        Div panel = new Div();

        // Base panel styling
        String bg = dark ? "#1a1a1a" : "#ffffff";
        String textColor = dark ? "#e0e0e0" : "#1a1a1a";
        String borderColor = dark ? "#444" : "#e0e0e0";

        panel.getStyle()
                .set("padding", "20px")
                .set("border-radius", "12px")
                .set("border", "1px solid " + borderColor)
                .set("background-color", bg)
                .set("color", textColor);

        // Set label color so toggle labels are readable
        String labelColor = dark ? "#e0e0e0" : "#1a1a1a";
        panel.getStyle()
                .set("--vaadin-checkbox-label-color", labelColor)
                .set("--vaadin-input-field-label-color", labelColor);

        // Set theme-specific CSS custom properties
        switch (theme) {
            case LUMO:
                if (dark) {
                    panel.getStyle()
                            .set("--lumo-contrast-40pct", "hsla(214, 96%, 96%, 0.38)")
                            .set("--lumo-primary-color", "hsl(214, 86%, 55%)")
                            .set("--lumo-primary-contrast-color", "#fff")
                            .set("--lumo-disabled-text-color", "hsla(214, 96%, 96%, 0.3)");
                } else {
                    panel.getStyle()
                            .set("--lumo-contrast-40pct", "hsla(214, 53%, 23%, 0.38)")
                            .set("--lumo-primary-color", "hsl(214, 90%, 52%)")
                            .set("--lumo-primary-contrast-color", "#fff");
                }
                break;
            case AURA:
                if (dark) {
                    panel.getStyle()
                            .set("--aura-contrast-40pct", "rgba(255, 255, 255, 0.38)")
                            .set("--aura-primary-color", "#a8c7fa")
                            .set("--aura-primary-contrast-color", "#062e6f");
                } else {
                    panel.getStyle()
                            .set("--aura-contrast-40pct", "rgba(26, 26, 26, 0.38)")
                            .set("--aura-primary-color", "#0957d0")
                            .set("--aura-primary-contrast-color", "#fff");
                }
                break;
            case NONE:
                // No CSS custom properties — uses plain fallbacks
                break;
        }

        // Title
        H4 heading = new H4(title);
        heading.getStyle()
                .set("margin", "0 0 12px 0")
                .set("font-size", "14px")
                .set("color", textColor);
        panel.add(heading);

        // Unchecked toggle
        ToggleButton off = new ToggleButton("Off state");
        panel.add(off);

        // Spacer
        Div spacer = new Div();
        spacer.getStyle().set("height", "8px");
        panel.add(spacer);

        // Checked toggle
        ToggleButton on = new ToggleButton("On state", true);
        panel.add(on);

        // Spacer
        Div spacer2 = new Div();
        spacer2.getStyle().set("height", "8px");
        panel.add(spacer2);

        // Disabled toggle
        ToggleButton disabled = new ToggleButton("Disabled");
        disabled.setEnabled(false);
        panel.add(disabled);

        return panel;
    }
}
