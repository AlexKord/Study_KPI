package ua.kpi.gofPatterns.abstractFactory;

public class AbstractFactoryApp {

    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        m.dbclick();
        k.print();
        k.println();
        t.track(10, 35);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code: " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dbclick();
    void scroll(int direction);
}

interface Keyboard {
    void print();
    void println();
}

interface Touchpad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dbclick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скроллим верх");
        } else if (direction < 0) {
            System.out.println("Скроллим вниз");
        } else {
            System.out.println("Не скроллим");
        }
    }
}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("Печатаем строкуg");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}

class RuTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}

class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dbclick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll Up");
        } else if (direction < 0) {
            System.out.println("Scroll Down");
        } else {
            System.out.println("No Scrolling");
        }
    }
}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print Line");
    }
}

class EnTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels");
    }
}

class EnDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}

class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}


