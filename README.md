# ToggleButton for Flow

Toggle button provides an on/off switch that users can toggle by tapping the switch.

Version 4.0.0 is compatible with **Vaadin 25.0.7** (Java 21, Spring Boot 4).

| Version | Vaadin |
|---------|--------|
| 1.x     | 14     |
| 2.0.0   | 23     |
| 3.0.0   | 23/24  |
| 4.0.0   | 25.0   |

## Usage

```java
ToggleButton toggle = new ToggleButton("Enable notifications");
toggle.addValueChangeListener(e -> {
    Notification.show("Notifications " + (e.getValue() ? "enabled" : "disabled"));
});
```

The component extends Vaadin's `Checkbox` with a `toggle-button` theme variant and custom CSS that renders it as a toggle switch. It supports both the **Lumo** and **Aura** themes.

## Maven

```xml
<dependency>
    <groupId>com.vaadin.componentfactory</groupId>
    <artifactId>togglebutton</artifactId>
    <version>4.0.0</version>
</dependency>
```

## Running the Demo

```bash
cd togglebutton-demo
mvn spring-boot:run
```

Then open http://localhost:8080/togglebutton

## Development

Clone and install to local Maven repository:

```bash
git clone git@github.com:vaadin-component-factory/toggle-button.git
mvn install
```

## License

Apache License 2.0
