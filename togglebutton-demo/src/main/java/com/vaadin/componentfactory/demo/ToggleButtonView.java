package com.vaadin.componentfactory.demo;

/*
 * #%L
 * Vaadin Component Factory Toggle Button Component for Vaadin 14
 * %%
 * Copyright (C) 2017 - 2019 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import com.vaadin.componentfactory.ToggleButton;
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
        ToggleButton toggle = new ToggleButton();
        toggle.setLabel("Label");
        // end-source-example
        addCard("Basic Usage", toggle);
    }

    private void exampleDisabledToggleButton() {
        // begin-source-example
        // source-example-heading: Disabled Toggle Button
        ToggleButton disabledToggle = new ToggleButton("Disabled");
        disabledToggle.setEnabled(false);
        ToggleButton disabledToggleChecked = new ToggleButton("Disabled and checked");
        disabledToggleChecked.setEnabled(false);
        disabledToggleChecked.setValue(true);
        // end-source-example
        addCard("Disabled Toggle Button", disabledToggle, disabledToggleChecked);
    }

    private void exampleValueChangeListener() {
        // begin-source-example
        // source-example-heading: Toggle Button with Value Change Listener
        ToggleButton toggle = new ToggleButton("Toggle");
        Div message = new Div();
        toggle.addValueChangeListener(evt -> message.setText(
                String.format("Toggle button value changed from '%s' to '%s'",
                        evt.getOldValue(), evt.getValue())));
        // end-source-example
        addCard("Toggle Button with Value Change Listener", toggle, message);
    }

}
