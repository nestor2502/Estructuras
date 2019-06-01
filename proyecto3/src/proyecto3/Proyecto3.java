
package proyecto3;

public class Proyecto3 {

         public Proyecto3() throws InterruptedException{
             
         inicia();
         }
         
         public void inicia()throws InterruptedException {
               Equipos Seoul = new Equipos("Seoul Dynasty", 200, "Seoul.png");
        Equipos Houston = new Equipos("Houston Outlaws", 180, "Houston.png");
        Equipos LAG = new Equipos("LA Gladiator", 210, "LosAngeles.png");
        Equipos NY = new Equipos("New York Excelsior", 240, "New York.png");
        Equipos Phily = new Equipos("Philadelphia Fusion", 230, "Philadelphia.png");
        Equipos Shangai = new Equipos("Shangai Dragons", 190, "Shangai.png");
        Equipos Vanc = new Equipos("Vancouver Titans", 215,"Vancouver.png");
        Equipos Atl = new Equipos("Atlanta Reign", 224, "Atlanta.png");
        Equipos[] arr = {Seoul,Houston,LAG,NY,Phily,Shangai,Vanc,Atl};
        Torneo1 test = new Torneo1(arr);
        test.cuartos();
        Thread.sleep(2000);
        test.mostrarCuartos();
        test.semifinal();
        Thread.sleep(2000);
        test.mostrarSemifinal();
        test.last();
        Thread.sleep(2000);
        test.mostrarLast();
         
         
         }
    public static void main(String[] args) throws InterruptedException {/**
        Equipos Seoul = new Equipos("Seoul Dynasty", 200, "Seoul.png");
        Equipos Houston = new Equipos("Houston Outlaws", 180, "Houston.png");
        Equipos LAG = new Equipos("LA Gladiator", 210, "LosAngeles.png");
        Equipos NY = new Equipos("New York Excelsior", 240, "New York.png");
        Equipos Phily = new Equipos("Philadelphia Fusion", 230, "Philadelphia.png");
        Equipos Shangai = new Equipos("Shangai Dragons", 190, "Shangai.png");
        Equipos Vanc = new Equipos("Vancouver Titans", 215,"Vancouver.png");
        Equipos Atl = new Equipos("Atlanta Reign", 224, "Atlanta.png");
        Equipos[] arr = {Seoul,Houston,LAG,NY,Phily,Shangai,Vanc,Atl};
        Torneo1 test = new Torneo1(arr);
        test.cuartos();
        Thread.sleep(2000);
        test.mostrarCuartos();
        test.semifinal();
        Thread.sleep(2000);
        test.mostrarSemifinal();
        test.last();
        Thread.sleep(2000);
        test.mostrarLast();
        /**
        test.iniciar();
        Thread.sleep(4000);
        test.mostrarCuartos();
        Thread.sleep(4000);
        test.mostrarSemifinal();
        Thread.sleep(4000);
        test.mostrarLast();
        //Thread.sleep(4000);
        //test.mostrarCuartos();
        * */
        
        Proyecto3 obj = new Proyecto3();
    }
    
}
