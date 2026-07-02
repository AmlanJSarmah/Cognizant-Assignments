package DesignPatterns;

class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String toString() {
        return "Computer{CPU='" + cpu + "', RAM='" + ram + "', Storage='" + storage + "'}";
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        Builder setCPU(String cpu) { this.cpu = cpu; return this; }
        Builder setRAM(String ram) { this.ram = ram; return this; }
        Builder setStorage(String storage) { this.storage = storage; return this; }
        Computer build() { return new Computer(this); }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .build();

        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
