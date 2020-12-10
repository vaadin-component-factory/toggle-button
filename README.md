# Component Factory Toggle Button for Vaadin 14

[Live Demo ↗](https://incubator.app.fi/togglebutton-demo/togglebutton)

[&lt;vcf-toggle-button&gt;](https://vaadin.com/directory/component/vaadin-component-factoryvcf-toggle-button) is a Web Component for displaying an toggle button.

# What does the component do?

Toggle button provides an on/off switch that user can toggle by tapping the switch

## Basic Usage
```java
ToggleButton toggle = new ToggleButton();
toggle.setLabel("Label");
```

## Disabled Toggle Button

```java
ToggleButton disabledToggle = new ToggleButton("Disabled");
disabledToggle.setEnabled(false);
```

## Toggle Button with Value Change Listener

```java
ToggleButton toggle = new ToggleButton("Toggle");
Div message = new Div();
toggle.addValueChangeListener(evt -> message.setText(
        String.format("Toggle button value changed from '%s' to '%s'",
                evt.getOldValue(), evt.getValue())));
```

# How to run the demo?

The Demo can be run by going to the project togglebutton-demo and executing the maven goal:

```mvn jetty:run```

After server startup, you'll be able find the demo at [http://localhost:8080/togglebutton](http://localhost:8080/togglebutton)


## License & Author

This Add-on is distributed under Apache 2.0

Component Factory Toggle Button is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)


## Setting up for development:

Clone the project in GitHub (or fork it if you plan on contributing)

```
git clone git@github.com:vaadin-component-factory/toggle-button.git
```

to install project to your maven repository run
 
```mvn install```