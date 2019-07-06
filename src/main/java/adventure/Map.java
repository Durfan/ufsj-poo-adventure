
package adventure;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    
    private static final Integer TROLLS = 5;
    private static final int SALAS = 22;
    private static ArrayList<Sala> sala;
    private static Boolean[][] config;
    private static String[][] nomesPortas;
    
    Map() {
        
        sala = new ArrayList<>();
        
        for (int i=0; i<SALAS; i++) {
            sala.add(new Sala());
        }

        sala.get( 0).conecta(sala.get( 1)); // A
        sala.get( 1).conecta(sala.get( 6)); // A
        sala.get( 1).conecta(sala.get( 2)); // B
        sala.get( 1).conecta(sala.get( 0)); // C
        sala.get( 2).conecta(sala.get( 1)); // A
        sala.get( 2).conecta(sala.get( 3)); // B
        sala.get( 3).conecta(sala.get( 2)); // A
        sala.get( 3).conecta(sala.get( 8)); // B
        sala.get( 4).conecta(sala.get(21)); // A
        sala.get( 4).conecta(sala.get( 5)); // B
        sala.get( 5).conecta(sala.get(10)); // A
        sala.get( 5).conecta(sala.get( 4)); // B
        sala.get( 6).conecta(sala.get( 1)); // A
        sala.get( 6).conecta(sala.get( 7)); // B
        sala.get( 7).conecta(sala.get(12)); // A
        sala.get( 7).conecta(sala.get( 6)); // B
        sala.get( 8).conecta(sala.get(13)); // A
        sala.get( 8).conecta(sala.get( 3)); // B
        sala.get( 9).conecta(sala.get(10)); // A
        sala.get(10).conecta(sala.get( 9)); // A
        sala.get(10).conecta(sala.get(15)); // B
        sala.get(10).conecta(sala.get( 5)); // C
        sala.get(11).conecta(sala.get(12)); // A
        sala.get(11).conecta(sala.get(16)); // B
        sala.get(12).conecta(sala.get(11)); // A
        sala.get(12).conecta(sala.get( 7)); // B
        sala.get(12).conecta(sala.get(13)); // C
        sala.get(13).conecta(sala.get(12)); // A
        sala.get(13).conecta(sala.get( 8)); // B
        sala.get(14).conecta(sala.get(15)); // A
        sala.get(14).conecta(sala.get(19)); // B
        sala.get(15).conecta(sala.get(14)); // A
        sala.get(15).conecta(sala.get(10)); // B
        sala.get(15).conecta(sala.get(20)); // C
        sala.get(16).conecta(sala.get(11)); // A
        sala.get(16).conecta(sala.get(17)); // B
        sala.get(17).conecta(sala.get(16)); // A
        sala.get(17).conecta(sala.get(18)); // B
        sala.get(18).conecta(sala.get(19)); // A
        sala.get(18).conecta(sala.get(17)); // B
        sala.get(19).conecta(sala.get(14)); // A
        sala.get(19).conecta(sala.get(18)); // B
        sala.get(20).conecta(sala.get(15)); // A
        sala.get(21).conecta(sala.get( 4)); // A
        
        config = new Boolean[][]{
            {true,false,false,false}, // Sala 0
            {true,true,true,false},   // Sala 1
            {false,true,false,true},  // Sala 2
            {true,false,false,true},  // Sala 3
            {false,true,true,false},  // Sala 4
            {true,false,false,true},  // Sala 5
            {false,true,true,false},  // Sala 6
            {true,false,false,true},  // Sala 7
            {true,false,true,false},  // Sala 8
            {false,true,false,false}, // Sala 9
            {true,false,true,true},   // Sala 10
            {true,true,false,false},  // Sala 11
            {false,true,true,true},   // Sala 12
            {false,false,true,true},  // Sala 13
            {true,true,false,false},  // Sala 14
            {true,false,true,true},   // Sala 15
            {false,true,true,false},  // Sala 16
            {false,true,false,true},  // Sala 17
            {false,true,false,true},  // Sala 18
            {false,false,true,true},  // Sala 19
            {false,false,true,false}, // Sala 20
            {true,false,false,false}, // Sala 21
        };
        
        nomesPortas = new String[][]{
            {"A","-","-","-"}, // Sala 0
            {"A","B","C","-"}, // Sala 1
            {"-","B","-","A"}, // Sala 2
            {"B","-","-","A"}, // Sala 3
            {"-","B","A","-"}, // Sala 4
            {"A","-","-","B"}, // Sala 5
            {"-","B","A","-"}, // Sala 6
            {"A","-","-","B"}, // Sala 7
            {"A","-","B","-"}, // Sala 8
            {"-","A","-","-"}, // Sala 9
            {"B","-","C","A"}, // Sala 10
            {"B","A","-","-"}, // Sala 11
            {"-","C","B","A"}, // Sala 12
            {"-","-","B","A"}, // Sala 13
            {"B","A","-","-"}, // Sala 14
            {"C","-","B","A"}, // Sala 15
            {"-","B","A","-"}, // Sala 16
            {"-","B","-","A"}, // Sala 17
            {"-","A","-","B"}, // Sala 18
            {"-","-","A","B"}, // Sala 19
            {"-","-","A","-"}, // Sala 20
            {"A","-","-","-"}, // Sala 21
        };
        
        Map.configura(sala);
        Map.setaTroll();
    }
    
    private static void configura(ArrayList<Sala> sala) {
    	
        for (int i=0; i<SALAS; i++) {
            sala.get(i).setPortaN(config[i][0]);
            sala.get(i).setPortaL(config[i][1]);
            sala.get(i).setPortaS(config[i][2]);
            sala.get(i).setPortaO(config[i][3]);
            sala.get(i).setNomePortaN(nomesPortas[i][0]);
            sala.get(i).setNomePortaL(nomesPortas[i][1]);
            sala.get(i).setNomePortaS(nomesPortas[i][2]);
            sala.get(i).setNomePortaO(nomesPortas[i][3]);
        }
        Random rand = new Random();
        ArrayList<Porta> portas;
        for(int i = 0; i < SALAS; i ++) {
        	portas = sala.get(i).getListPortas();
        	for(int j = 0; j < portas.size(); j++) {
        		if(rand.nextFloat() < 0.25) {
        			portas.get(j).setLocked(true);
        		} else {
        			portas.get(j).setLocked(false);
        		}
        	}
        }
        
        sala.get(0).getListPortas().get(0).setLocked(false);
    }
    
    private static void setaTroll() {
        Random rand = new Random();
        Integer aleatoria;
        for (int i=0; i<TROLLS; i++) {
            while (sala.get(aleatoria = rand.nextInt(20) + 1).temTroll());
            sala.get(aleatoria).setTroll(new Troll());
        }
    }
    
    public void movimentaTrolls() {
        for (int i=0; i<SALAS; i++) {
            if (sala.get(i).temTroll()) {
                sala.get(i).moveTroll();
            }
        }
    }

    public static Sala getSala(int i) {
        return sala.get(i);
    }
    
    public static int getSalaID(Sala n) {
        int index = sala.indexOf(n);
        return index;
    }

    public static int getSALAS() {
        return SALAS;
    }
    
}
