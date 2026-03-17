package com.vaadin.componentfactory;

/*-
 * #%L
 * Vaadin Component Factory Toggle Button Component for Vaadin 25
 * %%
 * Copyright (C) 2017 - 2026 Vaadin Ltd
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

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;

/**
 * Server-side component that provides an on/off toggle switch.
 * <p>
 * Implemented as a themed {@link Checkbox} with custom CSS styling to render
 * as a toggle switch. Supports both Lumo and Aura themes.
 *
 * @author Vaadin Ltd
 */
@CssImport(value = "./styles/vaadin-checkbox.css", themeFor = "vaadin-checkbox")
@SuppressWarnings("serial")
public class ToggleButton extends Checkbox implements HasTheme {

    public static final String THEME_NAME = "toggle-button";

    /**
     * Default constructor.
     */
    public ToggleButton() {
        super();
        addThemeName();
    }

    /**
     * Constructs a toggle button with the initial label text.
     *
     * @param labelText the label text to set
     */
    public ToggleButton(String labelText) {
        super(labelText);
        addThemeName();
    }

    /**
     * Constructs a toggle button with the initial value.
     *
     * @param initialValue the initial value
     */
    public ToggleButton(boolean initialValue) {
        super(initialValue);
        addThemeName();
    }

    /**
     * Constructs a toggle button with the initial label text and value.
     *
     * @param labelText    the label text to set
     * @param initialValue the initial value
     */
    public ToggleButton(String labelText, boolean initialValue) {
        super(labelText, initialValue);
        addThemeName();
    }

    /**
     * Constructs a toggle button with the initial label text and value change
     * listener.
     *
     * @param label    the label text to set
     * @param listener the value change listener to add
     */
    public ToggleButton(String label,
            ValueChangeListener<ComponentValueChangeEvent<Checkbox, Boolean>> listener) {
        super(label, listener);
        addThemeName();
    }

    private void addThemeName() {
        addThemeName(THEME_NAME);
    }
}
