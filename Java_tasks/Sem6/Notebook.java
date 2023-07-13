package Java_tasks.Sem6;

public class Notebook {
    private String name;
    private String color;
    private int ram;
    private int hardDrive;
    private String os;

    public Notebook (String name, String color, int ram, int hardDrive, String os){
        this.name = name;
        this.color = color;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Notebook [name=" + name + ", color=" + color + ", ram=" + ram + ", hardDrive=" + hardDrive + ", os="
                + os + "]";
    }
    
}
