import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Publicaciones> inventario = new ArrayList<>();
    public static ArrayList<Socio> listado = new ArrayList<>();

    public static void main(String[] args) {

        Publicaciones libro;
        Publicaciones revista;
        Publicaciones manual;
        Socio so_mayor;
        Socio so_menor;

        String titulo, isbn, editorial, tema, nombre, dni, telf, tipo, categoria, idioma;
        int ano, num_public;
        boolean disponibilidad;
        Scanner sc = new Scanner(System.in);


        añadir(inventario, sc);
        buscar(inventario, sc);
        modificar(inventario, sc);
        eliminar(inventario, sc);
        mostrar_inventario(inventario);


        add_socio(listado, sc);
        modificar_socio(listado, sc);
        eliminar_socio(listado, sc);
        mostrar_listado(listado);
        buscarsocio(listado, sc);
        registrar_prestamo(inventario, listado, sc);
        devolver_prestamo(listado, sc);



    }


    //LIBROS
    public static void añadir(ArrayList<Publicaciones> inventario, Scanner sc) {
    String titulo, isbn, editorial, tema, categoria;
    int ano, num_public;
    boolean disponibilidad;

    System.out.println("Titulo");
    titulo = sc.next();
    System.out.println("Año");
    ano = sc.nextInt();
    System.out.println("Disponibilidad");
    disponibilidad = true;
    System.out.println("Que tipo de publicacion es? Libro/Revista/Manual");
    String tipo = sc.next().toLowerCase();
    switch (tipo) {
        case "1" -> {
            System.out.println("ISBN");
            isbn = sc.next();
            System.out.println("Categoria");
            categoria = sc.next();
            Publicaciones libro = new Libro(titulo, ano, disponibilidad, isbn, categoria);
            inventario.add(libro);
        }
        case "2" -> {
            System.out.println("Numero de publicaciones");
            num_public = sc.nextInt();
            System.out.println("Editorial");
            editorial = sc.next();
            Publicaciones revista = new Revista(titulo, ano, disponibilidad, num_public, editorial);
            inventario.add(revista);
        }
        case "3" -> {
            System.out.println("Idioma");
            String idioma = sc.next();
            System.out.println("Tema");
            tema = sc.next();
            Publicaciones manual = new Manual(titulo, ano, disponibilidad, idioma, tema);
            inventario.add(manual);
        }
        default -> {
        }
    }
}

    public static void buscar(ArrayList<Publicaciones> inventario, Scanner sc) {
    System.out.println("¿Qué tipo de libro busca (revista, libro, manual)?");
    String opcion = sc.next().toLowerCase();
    int eleccion;

    switch (opcion) {
        case "revista" -> eleccion = 1;
        case "libro" -> eleccion = 2;
        case "manual" -> eleccion = 3;
        default -> {
            System.out.println("Opción no contemplada");
            return;
        }
    }

    System.out.println("Dime el título:");
    String titulo = sc.next();

    switch (eleccion) {
        case 1 -> {
            for (Publicaciones libro : inventario) {
                if (libro instanceof Revista && libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Libro encontrado:\n" + libro.mostrarInfo());
                    return;
                }
            }
        }
        case 2 -> {
            for (Publicaciones revista : inventario) {
                if (revista instanceof Libro && revista.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Libro encontrado:\n" + revista.mostrarInfo());
                    return;
                }
            }
        }
        case 3 -> {
            for (Publicaciones manual : inventario) {
                if (manual instanceof Manual && manual.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Libro encontrado:\n" + manual.mostrarInfo());
                    return;
                }
            }
        }
        default -> System.out.println("Error, no eligió un tipo de libro contemplado.");
    }

    System.out.println("Libro no encontrado.");
}

    public static void modificar(ArrayList<Publicaciones> inventario, Scanner sc) {
        System.out.println("¿Qué tipo de libro busca (revista, libro, manual)?");
        String opcion = sc.next().toLowerCase();

        int eleccion = switch (opcion) {
            case "libro" -> 1;
            case "revista" -> 2;
            case "manual" -> 3;
            default -> {
                System.out.println("Opción no contemplada");
                yield -1;
            }
        };

        System.out.println("Dime el título:");
        sc.nextLine();
        String tituloBuscado = sc.nextLine();

        switch (eleccion) {
            case 1 -> {
                for (Publicaciones publicacion : inventario) {
                    if (publicacion instanceof Revista && publicacion.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                        System.out.println("Revista encontrada\n");
                        System.out.println("Ahora puede modificar la revista");
                        System.out.println("Categoria:");
                        String categoria = sc.nextLine();
                        ((Libro) publicacion).setCategoria(categoria);
                        return;
                    }
                }
            }
            case 2 -> {
                for (Publicaciones publicacion : inventario) {
                    if (publicacion instanceof Libro && publicacion.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                        System.out.println("Libro encontrado\n");
                        System.out.println("Ahora puede modificar el libro");
                        System.out.println("Empecemos por el Editorial:");
                        String editorial = sc.nextLine();
                        ((Revista) publicacion).setEditorial(editorial);
                        System.out.println("Numero de publicación:");
                        int num_public = sc.nextInt();
                        ((Revista) publicacion).setNum_public(num_public);
                        return;
                    }
                }
            }
            case 3 -> {
                for (Publicaciones publicacion : inventario) {
                    if (publicacion instanceof Manual && publicacion.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                        System.out.println("Manual encontrado:\n");
                        System.out.println("Ahora puede modificar el manual");
                        System.out.println("Empecemos cambiando el idioma:");
                        String idioma = sc.nextLine();
                        ((Manual) publicacion).setIdioma(idioma);
                        System.out.println("Tema:");
                        String tema = sc.nextLine();
                        ((Manual) publicacion).setTema(tema);
                        return;
                    }
                }
            }
            default -> System.out.println("Error, no eligió un tipo de libro contemplado.");
        }

        System.out.println("Libro no encontrado.");
    }

    public static void eliminar(ArrayList<Publicaciones> inventario, Scanner sc) {
        String opcion;
        int eleccion = 0;

        System.out.println("¿Qué tipo de libro busca (revista, libro, manual)?");
        opcion = sc.next().toLowerCase();

        switch (opcion) {
            case "revista" -> eleccion = 1;
            case "libro" -> eleccion = 2;
            case "manual" -> eleccion = 3;
            default -> {System.out.println("Opción no contemplada");}
        }
        System.out.println("Dime el título:");
        String tituloBuscado = sc.next();
        Iterator<Publicaciones> iterador = inventario.iterator();
        while (iterador.hasNext()) {
            Publicaciones libro = iterador.next();
            if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                iterador.remove();
            }
        }
    }

    public static void mostrar_inventario(ArrayList<Publicaciones> inventario){
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("Inventario");
        for (Publicaciones libro : inventario) {
            System.out.println(libro.mostrarInfo());
        }
    }


    //SOSCIOS
    public static void add_socio(ArrayList<Socio> listado, Scanner sc) {
        boolean mayoredad;
        System.out.println("Nombre");
        String nombre = sc.next();
        System.out.println("Numero de socio");
        int num_socio = sc.nextInt();
        System.out.println("Es usted mayor de edad");
        String respuesta = sc.next().toLowerCase();
        if (respuesta.equals("si")) {
            mayoredad = true;
        } else {
            mayoredad = false;
        }

        if(mayoredad) {
            System.out.println("dni");
            String dni = sc.next();
            System.out.println("Telefono");
            String telf = sc.next();
            listado.add(new Smayor(nombre, num_socio, dni, telf));
        }else {
            Socio socio = new Smenor(nombre, num_socio);
            listado.add(socio);
        }
    }

    public static void modificar_socio(ArrayList<Socio> listado, Scanner sc) {
        String nombre;
        System.out.println("DIme el numero de socio");
        int num_socio=sc.nextInt();
        Socio socio = listado.get(num_socio);
        if (socio instanceof Smayor) {
            System.out.println("Nombre");
            nombre = sc.next();
            ((Smayor) socio).setNombre(nombre);
        } else if (socio instanceof Smenor) {
            System.out.println("Nombre");
            nombre = sc.next();
            ((Smenor) socio).setNombre(nombre);
        }
    }

    public static void eliminar_socio(ArrayList<Socio> listado, Scanner sc) {
        System.out.println("DIme el numero de socio");
        int num_socio=sc.nextInt();
        Socio socio = listado.get(num_socio);
        if (socio instanceof Smayor) {
            listado.remove(num_socio);
        } else if (socio instanceof Smenor) {
            listado.remove(num_socio);
        }
    }

    public static void mostrar_listado(ArrayList<Socio> listado) {
        System.out.println("LIstado Socio");
        for (Socio socio : listado) {
            System.out.println(socio.mostrar_info());
        }


    }

    public static void buscarsocio(ArrayList<Socio> listado, Scanner sc) {
        if (listado.isEmpty()) {
            System.out.println("La lista de socios está vacía.");
            return;
        }
        System.out.println("Dime el número de socio:");
        int numSocio = sc.nextInt();
        for (Socio socio : listado) {
            if (socio.getNum_Socio() == numSocio) {
                if (socio instanceof Smayor) {
                    System.out.println("Socio mayor encontrado:\n" + socio.mostrar_info());
                } else if (socio instanceof Smenor) {
                    System.out.println("Socio menor encontrado:\n" + socio.mostrar_info());
                }
                return;
            }
        }
        System.out.println("Socio no encontrado.");
    }

    // prestamo socios
    public static void registrar_prestamo(ArrayList<Publicaciones> inventario, ArrayList<Socio> listado, Scanner sc) {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío, no se pueden registrar préstamos.");
            return;
        }
        if (listado.isEmpty()) {
            System.out.println("La lista de socios está vacía, no se pueden registrar préstamos.");
            return;
        }
        System.out.println("Dime el número de socio:");
        int numSocio = sc.nextInt();
        Socio socioEncontrado = null;
        for (Socio socio : listado) {
            if (socio.getNum_Socio() == numSocio) {
                socioEncontrado = socio;
                break;
            }
        }
        if (socioEncontrado == null) {
            System.out.println("Socio no encontrado.");
            return;
        }
        System.out.println("Dime el título de la publicación:");
        String tituloPublicacion = sc.next();
        for (Publicaciones publicacion : inventario) {
            if (publicacion.getTitulo().equalsIgnoreCase(tituloPublicacion)) {
                System.out.println("Préstamo registrado correctamente.");
                return;
            }
        }
        System.out.println("Publicación no encontrada.");
    }

    public static void devolver_prestamo(ArrayList<Socio> listado, Scanner sc) {
        if (listado.isEmpty()) {
            System.out.println("La lista de socios está vacía, no se pueden devolver préstamos.");
            return;
        }
        System.out.println("Dime el número de socio:");
        int numSocio = sc.nextInt();
        for (Socio socio : listado) {
            if (socio.getNum_Socio() == numSocio) {
                System.out.println("Publicación devuelta correctamente.");
                // Aquí iría la lógica para devolver el préstamo
                return;
            }
        }
        System.out.println("Socio no encontrado.");
    }
}