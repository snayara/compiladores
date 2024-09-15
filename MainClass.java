import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
String  r2;
int  a;
int  b;
String  r;
int  c;
int  resultado;
String  strC;
String  strA;
String  strB;
String  r1;
strA="Escreva um número (a): ";
System.out.println(strA);
a = _key.nextInt();
strB="Escreva um número (b): ";
System.out.println(strB);
b = _key.nextInt();
strC="Escreva um número (c): ";
System.out.println(strC);
c = _key.nextInt();
resultado=a+b*c/b;
r="Resultado igual a:";
r1="Resultado maior que 10";
r2="Resultado menor que 10";
if (resultado>10) {
System.out.println(r);System.out.println(resultado);System.out.println(r1);}else {
System.out.println(r);System.out.println(resultado);System.out.println(r2);}

  }}