//package padsof.p2.usuario;


/**
 * Clase usuario.
 * 
 * @author Elena Cano
 * @author Pablo Izaguirre
 * @author Miguel Escribano
 */


import java.util.*;


abstract class Usuario {
    private String nombreUsuario = "pepe";
    private static ArrayList<String> listaNombres = new ArrayList();
 

    public Usuario (String nombre){
        nombreUsuario= nombre;


    }

    public getNombreUsuario (){
        return nombreUsuario;
    }
    

    public boolean setNombreUsuario (String nombre){
        if (listaNombres.contains(nombre)){
            return false;
        }
        else{
            nombreUsuario=nombre;
            listaNombres.add(nombre);
            return true;
        }
        
    }

    public ArrayList<String> getListaNombres() { return listaNombres; }
















    public String toString(){
        return "Primos hasta "+ max+ " = "+primos;
    }

 
    public SortedSet<Integer> divisoresPrimos(int n){
        SortedSet<Integer> divisores= new TreeSet<>();

        if(compruebaPrimo(n)) return divisores;
        for (int p:primos){
            if (n % p == 0){
                divisores.add(p);
            }
        }
        return divisores;
    }

  
    public boolean esPrimo(int n){
        if (n<2) return false;
        if (n>max) actualizaPrimos(n);
        return primos.contains(n);
    }


 
    private void actualizaPrimos(int n){
        for(int i = max + 1; i <= n; ++i){
            if (compruebaPrimo(i)){
                primos.add(i);
            }
        }
        max = n;
    }
    

    private boolean compruebaPrimo(int n){
        for(int p:primos){
            if(n % p == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        if (args.length<1) {
            System.out.println("Se espera al menos un número.");
        
        }
        else {
            Primos p = new Primos();
            for (String s: args){
                System.out.println("¿El número " + s + " es primo? " + p.esPrimo(Integer.parseInt(s)));
                if (!p.esPrimo(Integer.parseInt(s))){
                    System.out.println("Lista de divisores primos de " + s + ": " + p.divisoresPrimos(Integer.parseInt(s)));
                }
            }
            System.out.println(p);
        }
    }
}