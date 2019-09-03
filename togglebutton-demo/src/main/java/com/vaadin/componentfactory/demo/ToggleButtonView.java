package com.vaadin.componentfactory.demo;

/*
 * #%L
 * Vaadin Component Factory Toggle Button Example for Vaadin 14
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file license.html distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.componentfactory.VcfToggleButton;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * Server-side component Example for the <code>vcf-toggle-button</code> element.
 *
 * @author Vaadin Ltd
 */
@Route("togglebutton")
public class ToggleButtonView extends DemoView {

    @Override
    protected void initView() {
        exampleBasicToggleButton();
        exampleDisabledToggleButton();
        exampleValueChangeListener();
    }

    private void exampleBasicToggleButton() {
        // begin-source-example
        // source-example-heading: Basic Usage
        VcfToggleButton toggle = new VcfToggleButton();
        toggle.setLabel("Label");
        // end-source-example
        addCard("Basic Usage", toggle);
    }

    private void exampleDisabledToggleButton() {
        // begin-source-example
        // source-example-heading: Disabled Toggle Button
        VcfToggleButton disabledToggle = new VcfToggleButton("Disabled");
        disabledToggle.setEnabled(false);
        // end-source-example
        addCard("Disabled Toggle Button", disabledToggle);
    }

    private void exampleValueChangeListener() {
        // begin-source-example
        // source-example-heading: Toggle Button with Value Change Listener
        VcfToggleButton toggle = new VcfToggleButton("Toggle");
        Div message = new Div();
        toggle.addValueChangeListener(evt -> message.setText(
                String.format("Toggle button value changed from '%s' to '%s'",
                        evt.getOldValue(), evt.getValue())));
        // end-source-example
        addCard("Toggle Button with Value Change Listener", toggle, message);
    }

}
