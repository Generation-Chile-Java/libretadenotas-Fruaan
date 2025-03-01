import java.util.*;

public class LibretaDeNotas {

    public static void main(String[] args) {
        //Evaluar y almacenar la lista de estudiantes

        //HashMap para almacenar calificaciones de los estudiantes
        //Clave: nombre del estudiante y Valor: lista de notas (ArrayList<Double>)
        Map<String, ArrayList<Double>> calificaciones = new HashMap<>();

        int cantidadAlumnos, cantidadNotas;
        Scanner sc = new Scanner(System.in);

        //Solicitar cantidad de alumnos al usuario
        System.out.println("Ingrese la cantidad de estudiantes");
        cantidadAlumnos = sc.nextInt();
        sc.nextLine();
        while (cantidadAlumnos <= 0) {
            System.out.println("Cantidad invalida, ingrese la cantidad de estudiantes");
            cantidadAlumnos = sc.nextInt();
            sc.nextLine();
        }

        //Solicitar cantidad de notas por alumno
        System.out.println("Ingrese la cantidad de notas por alumno");
        cantidadNotas = sc.nextInt();
        sc.nextLine();
        while (cantidadNotas <= 0) {
            System.out.println("Cantidad invalida, ingrese un número positivo");
            cantidadNotas = sc.nextInt();
            sc.nextLine();
        }

        //Pedir nombre y notas de cada estudiante
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre del estudiante N°" + (i+1) + ": ");
            String estudiante = sc.nextLine();


            ArrayList<Double> notas = new ArrayList<>();
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la nota N°" + (j+1) + " para " + estudiante + ": ");
                double nota = sc.nextDouble();

                while (nota < 1 || nota > 7) {
                    System.out.println("La nota no es válida. Ingrese una nota del 1 al 7");
                    nota = sc.nextDouble();
                }
                notas.add(nota);

            }
            sc.nextLine();
            calificaciones.put(estudiante, notas);
        }

        System.out.println("Listado de estudiantes con sus notas");
        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
            System.out.println("Estudiante: " + entry.getKey() + " - Notas: " + entry.getValue());
        }

        //Mostrar Promedio, nota maxima y minima de cada estudiante
        System.out.println("Listado de estudiantes con sus notas");
        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
         String nombreEstudiante = entry.getKey();
         ArrayList<Double> notas = entry.getValue();
         double suma = 0;
         double notaMax = Double.MIN_VALUE;
         double notaMin = Double.MAX_VALUE;

         for (double nota : notas) {
            suma += nota;
            if (nota > notaMax) {
                notaMax = nota;
            }
            if (nota < notaMin) {
                notaMin = nota;
            }
         }
         double promedio = suma / notas.size();
            System.out.println("Estudiante: " + nombreEstudiante + " - Promedio: " + promedio + " - Nota Máxima: " + notaMax + " - Nota Minima " + notaMin);

        }


        //Menú de opciones
        int opcion;
        do {
            System.out.println( "** Menú de Opciones ** +" +
                    "\n 1. Mostrar el Promedio de Notas por Estudiante" +
                    "\n 2. Mostrar si la Nota es Aprobatoria o Reprobatoria por estudiante" +
                    "\n 3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante" +
                    "\n 0. Salir del Menú" +
                    "\n Selecciona una opción");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: //Promedio de notas
                    for (String estudiantes : calificaciones.keySet()) {
                        List<Double> notas = calificaciones.get(estudiantes);
                        double suma = 0;
                        for (double n : notas) {
                            suma += n;
                        }
                        double promedio = suma / notas.size();
                        System.out.println(estudiantes + " - Promedio: " + promedio);
                    }
                    break;

                case 2: // Mostrar si es Aprobatorio o Reprobatorio
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String estudiante = sc.nextLine();

                    System.out.print("Ingrese la nota: ");
                    int nota = sc.nextInt();

                    if (nota >= 4) {
                        System.out.println("La nota de " + estudiante + " es Aprobatoria.");
                    } else {
                        System.out.println("La nota de " + estudiante + " es Reprobatoria.");
                    }
                    break;

                case 3: //Mostrar si nota está Sobre o Debajo del promedio
                    double sumaTotal = 0;
                    int totalNotas = 0;
                    for (ArrayList<Double> notas : calificaciones.values()) {
                        for (double n : notas) {
                            sumaTotal += n;
                        }
                        totalNotas += notas.size();
                    }
                    double promedioCurso = totalNotas > 0 ? sumaTotal / totalNotas : 0;
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String estudianteComp = sc.nextLine();

                    System.out.print("Ingrese la nota: ");
                    int notaComp = sc.nextInt();

                    if (notaComp >= promedioCurso) {
                        System.out.println("La nota de " + estudianteComp + " está Sobre el Promedio del curso.");
                    } else {
                        System.out.println("La nota de " + estudianteComp + " está por Debajo del Promedio del curso.");
                    }
                    break;
                case 0:
                    System.out.println("Se ha finalizado el programa");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        } while (opcion != 0);

        sc.close();




    }
}
