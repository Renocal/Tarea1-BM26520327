import java.util.*;

// TAREA 1 - ESTRUCTURA DE DATOS - UN SOLO ARCHIVO
// Alumno: Frida Renata Calixto Zamora - BM26520327

// ===== CLASE PADRE =====
class Empleado {
    // ENCAPSULAMIENTO: privado, protegido, publico
    private String nombre_privado; // atributo privado
    protected double salario_protegido; // atributo protegido
    public String departamento_publico; // atributo publico

    // VARIABLES PRIMITIVO Y NO PRIMITIVO INTERCALADAS - 7+ tipos distintos
    public int edad_primitiva; // primitivo int
    public Integer edad_objeto; // objeto Integer - misma variable
    public double sueldo_primitivo; // primitivo double
    public Double sueldo_objeto; // objeto Double
    public boolean activo_primitivo; // primitivo boolean
    public Boolean activo_objeto; // objeto Boolean
    public String nombre_completo; // String
    public char inicial_primitiva; // char
    public long id_primitivo; // long

    // ESTRUCTURAS QUE PIDEN
    public ArrayList<String> habilidades; // ArrayList
    public LinkedList<String> tareas; // LinkedList
    public HashSet<String> certificaciones; // HashSet
    public HashMap<String, Integer> proyectos; // HashMap

    // Constructor
    public Empleado(String nombre, double salario, String depto) {
        this.nombre_privado = nombre;
        this.salario_protegido = salario;
        this.departamento_publico = depto;
        // Inicializar estructuras
        habilidades = new ArrayList<>();
        tareas = new LinkedList<>();
        certificaciones = new HashSet<>();
        proyectos = new HashMap<>();
        // Ejemplo primitivo vs objeto
        edad_primitiva = 22;
        edad_objeto = Integer.valueOf(22); // mismo valor pero como objeto
        sueldo_primitivo = salario;
        sueldo_objeto = Double.valueOf(salario);
    }

    // METODO PARA POLIMORFISMO - sera sobreescrito
    public void trabajar() {
        System.out.println("Empleado generico trabajando en " + departamento_publico);
    }

    // GETTER Y SETTER para atributo privado
    public String getNombre() { return nombre_privado; }
    public void setNombre(String nombre) { this.nombre_privado = nombre; }
}

// ===== 3 CLASES HIJAS - HERENCIA =====
class Desarrollador extends Empleado {
    public Desarrollador(String nombre, double salario) {
        super(nombre, salario, "Sistemas"); // llama a padre
    }
    @Override // POLIMORFISMO: reinterpreta metodo padre
    public void trabajar() {
        System.out.println("Desarrollador " + getNombre() + " programando en Java");
    }
}

class Disenador extends Empleado {
    public Disenador(String nombre, double salario) {
        super(nombre, salario, "Diseno");
    }
    @Override
    public void trabajar() {
        System.out.println("Disenador " + getNombre() + " disenando UI");
    }
}

class Gerente extends Empleado {
    public Gerente(String nombre, double salario) {
        super(nombre, salario, "Gerencia");
    }
    @Override
    public void trabajar() {
        System.out.println("Gerente " + getNombre() + " gestionando equipo");
    }
}

// ===== MAIN - DONDE SE VE TODO =====
public class Main {
    public static void main(String[] args) {
        // HERENCIA: objetos de clases hijas
        Desarrollador dev = new Desarrollador("Frida", 20000);

        // Llenar estructuras
        dev.habilidades.add("Java");
        dev.habilidades.add("Git");
        dev.tareas.add("Corregir bug");
        dev.certificaciones.add("Scrum");
        dev.proyectos.put("Tarea1 Estructura Datos", 10);

        System.out.println("Edad primitiva: " + dev.edad_primitiva + " vs Edad objeto: " + dev.edad_objeto);
        System.out.println("Habilidades: " + dev.habilidades);
        System.out.println("Tareas: " + dev.tareas);

        // POLIMORFISMO: clase padre con constructor de hijas
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new Desarrollador("Ana", 21000);
        empleados[1] = new Disenador("Luis", 19000);
        empleados[2] = new Gerente("Mtro. Magdiel", 35000);

        // Ciclo que ejecuta metodo en todos - polimorfismo
        System.out.println("\n--- POLIMORFISMO EN ACCION ---");
        for (Empleado e : empleados) {
            e.trabajar(); // cada uno hace su version
        }
    }
}