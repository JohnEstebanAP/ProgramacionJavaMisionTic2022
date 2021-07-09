/**Ejemplo 5: Estructura dependiendo de o Según

Una determinada empresa ha decidido ofrecer 
descuentos a sus clientes de acuerdo al día 
de la semana en el que se realice la compra, 
para lo cual se requiere un algoritmo que dado 
el día de la semana (en número), y el total a 
pagar sin descuento, calcule el total incluyendo 
el descuento. 
El descuento se otorga de acuerdo a la siguiente 
tabla.


Dia     Descuento
1       5%
2       3%
3       10%
4       4%
5       6%
6       2%
7       1%
 */

 import java.util.Scanner;
public class ejemplo5 {
    public static void main(String[] args) {
     
        Scanner leer= new Scanner(System.in);
        System.out.print("Digite por favor el dia de la semana: \n1.Lunes \n2.Martes \n3.Miercoles \n4.Jueves \n5.Viernes \n6.Savado \n7.Dimingo\n:");
        int dia= leer.nextInt();

        System.out.print("Digite por favor el valor total de la compra: ");
        double compra= leer.nextDouble();

        double descuento = 0;
        double total = 0;
        switch (dia){
            case 1:
                descuento = compra*0.05;
                break;
            case 2:
                descuento = compra*0.03;
                break;
            case 3:
                descuento = compra*0.1;
                break;
            case 4:
                descuento = compra*0.04;
                break;
            case 5:
                descuento = compra*0.06;
                break;
            case 6:
                descuento = compra*0.02;
                break;
            case 7:
                descuento = compra*0.01;
                break;
        }
        total = compra - descuento;

        System.out.print("El totla a pagar es de: "+ total+ " Con un Descuneot de: "+descuento);

    }
}
