package com.vaadin.componentfactory;

import com.vaadin.flow.component.HasTheme;

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

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;

/**
 *
 * @author Vaadin Ltd
 */

@CssImport(value = "./styles/vaadin-checkbox.css", themeFor = "vaadin-checkbox")
@SuppressWarnings("serial")
public class ToggleButton extends Checkbox implements HasTheme {
    public static final String THEME_NAME = "toggle-button";

    public ToggleButton() {
        super();
        addThemeName();
    }

    private void addThemeName() {
        addThemeName(THEME_NAME);
    }

    public ToggleButton(boolean initialValue) {
        super(initialValue);
        addThemeName();
    }

    public ToggleButton(String labelText, boolean initialValue) {
        super(labelText, initialValue);
        addThemeName();
    }

    public ToggleButton(
        String label, ValueChangeListener<ComponentValueChangeEvent<Checkbox, Boolean>> listener) {
        super(label, listener);
        addThemeName();
    }

    public ToggleButton(String labelText) {
        super(labelText);
        addThemeName();
    }
}