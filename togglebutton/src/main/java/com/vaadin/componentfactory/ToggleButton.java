package com.vaadin.componentfactory;

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

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

/**
 * Server-side component for the <code>vcf-toggle-button</code> element.
 *
 * @author Vaadin Ltd
 */

@Tag("vcf-toggle-button")
@NpmPackage(value = "@vaadin-component-factory/vcf-toggle-button", version = "1.0.3")
@JsModule("@vaadin-component-factory/vcf-toggle-button")
@CssImport(value = "./styles/vaadin-checkbox.css", themeFor = "vaadin-checkbox")
@SuppressWarnings("serial")
public class ToggleButton extends
        AbstractSinglePropertyField<ToggleButton, Boolean> implements HasStyle,
        HasSize, Focusable<ToggleButton>, ClickNotifier<ToggleButton> {

    /**
     * Default constructor.
     */
    public ToggleButton() {
        super("checked", false, false);
    }

    /**
     * Constructs a toggle button with the initial label text.
     *
     * @param labelText
     *            the label text to set
     * @see #setLabel(String)
     */
    public ToggleButton(String labelText) {
        this();
        setLabel(labelText);
    }

    /**
     * Constructs a toggle button with the initial value.
     *
     * @param initialValue
     *            the initial value
     * @see AbstractField#setValue(Object)
     */
    public ToggleButton(boolean initialValue) {
        this();
        setValue(initialValue);
    }

    /**
     * Constructs a toggle button with the initial value.
     *
     * @param labelText
     *            the label text to set
     * @param initialValue
     *            the initial value
     * @see #setLabel(String)
     * @see AbstractField#setValue(Object)
     */
    public ToggleButton(String labelText, boolean initialValue) {
        this(labelText);
        setValue(initialValue);
    }

    /**
     * Constructs a toggle button with the initial label text and value change
     * listener.
     *
     * @param label
     *            the label text to set
     * @param listener
     *            the value change listener to add
     * @see #setLabel(String)
     * @see #addValueChangeListener(ValueChangeListener)
     */
    public ToggleButton(String label,
            ValueChangeListener<ComponentValueChangeEvent<ToggleButton, Boolean>> listener) {
        this(label);
        addValueChangeListener(listener);
    }

    /**
     * Get the current label text.
     *
     * @return the current label text
     */
    public String getLabel() {
        return getElement().getProperty("label");
    }

    /**
     * Sets label of toggle button
     *
     * @param label
     *            the label text to set
     */
    public void setLabel(String label) {
        getElement().setProperty("label", label);
    }

    /**
     * If true, the user cannot interact with this element.
     * <p>
     * This property is not synchronized automatically from the client side, so
     * the returned value may not be the same as in client side.
     * </p>
     *
     * @return the {@code disabled} property from the webcomponent
     */
    protected boolean isDisabled() {
        return getElement().getProperty("disabled", false);
    }

    /**
     * Disables the toggle button.
     *
     * @param disabled
     *            the boolean value to set
     */
    public void setDisabled(boolean disabled) {
        getElement().setProperty("disabled", disabled);
    }

    @DomEvent("change")
    public static class ChangeEvent extends ComponentEvent<ToggleButton> {
        public ChangeEvent(ToggleButton source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    /**
     * Adds a listener for {@code change} events fired by the webcomponent.
     *
     * @param listener
     *            the listener
     * @return a {@link Registration} for removing the event listener
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Registration addChangeListener(
            ComponentEventListener<ChangeEvent> listener) {
        return addListener(ChangeEvent.class,
                (ComponentEventListener) listener);
    }

}
