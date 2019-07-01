
package adventure;

import java.util.Random;

public class Troll {
    
    private String nome;
    private Integer trollID;
    private final String[] name = {"Sam Sung", "Mrs. Butt",
        "P. Ennis", "Mike Litoris", "Dr. Faartz", "Lord Brain"};
    
    Troll() {
        Random rand = new Random();
        this.nome = name[rand.nextInt(5)];
        this.trollID = rand.nextInt(999);
    }

    public String getNome() {
        return nome;
    }

    public void setTrollID(Integer trollID) {
        this.trollID = trollID;
    }

    public Integer getTrollID() {
        return trollID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
