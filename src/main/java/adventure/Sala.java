
package adventure;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Sala {
    
    private final ArrayList<Porta> portas = new ArrayList<>();
    private final Stash stash;
    private Troll troll;
    private Boolean portaN;
    private Boolean portaL;
    private Boolean portaS;
    private Boolean portaO;
    private String nomePortaN;
    private String nomePortaL;
    private String nomePortaS;
    private String nomePortaO;
    
    Sala() {
        this.stash = new Stash();
    }
    
    public ArrayList<Porta> getListPortas() {
    	return this.portas;
    }
    
    public void conecta(Sala sala) {
        Porta porta = new Porta(this, sala);
        this.portas.add(porta);
    }

    public Sala moveTo(Sala sala, String door) {
        int index = door.charAt(0) - 65;
        if (index >= 0 && index < portas.size() && this.portas.get(index).getLocked()) {
             return this.portas.get(index).proximaSala(sala);
        } else {
            return sala;
        }
    }
    
    public Sala moveTo(Sala sala, String door, Player player) {
    	int index = door.charAt(0) - 65;
        if (index >= 0 && index < portas.size()) {
            if (this.portas.get(index).getLocked() == true) {
        	if (player.buscaChave(door) != null) {
                    this.portas.get(index).setLocked(false);
                    return this.portas.get(index).proximaSala(sala);
        	}
        	} else {
                    return this.portas.get(index).proximaSala(sala);
            }
        }
        return sala;
    }
    
    public String moveToSTR(Sala sala, String door, Player player) {
    	int index = door.charAt(0) - 65;
    	String conteudo = new String();
        if (index >= 0 && index < portas.size()) {
            if (this.portas.get(index).getLocked() == true) {
        	if (player.buscaChave(door) == null) {
                    conteudo = "\nPorta trancada, procure pela chave " + door + "\n";
        	}
            }
        }        
        return conteudo;
    }
    
    public void moveTroll() {
        int aleatoria = ThreadLocalRandom.current().nextInt(0,this.portas.size());
        if(!portas.get(aleatoria).getLocked()) {
	        if (portas.get(aleatoria).getProxima().getTroll() == null && this.troll != null) {
	            portas.get(aleatoria).getProxima().setTroll(this.troll);
	            portas.get(aleatoria).getProxima().getStash().setProtegido(true);
	            this.troll = null;
	            this.stash.setProtegido(false);
	        }
        }
    }
    
    
    public void pickUp(Player player, Object item) {
        if (item instanceof Ouro) {
            Integer doStash = this.stash.getOuro().getQuantidade();
            Integer mochila = player.getOuro().getQuantidade();
            player.getOuro().setQuantidade(mochila += doStash);
            this.stash.getOuro().setQuantidade(0);
        } else if (item instanceof Diamante) {
            Integer doStash = this.stash.getDiamante().getQuantidade();
            Integer mochila = player.getDiamante().getQuantidade();
            player.getDiamante().setQuantidade(mochila += doStash);
            this.stash.getDiamante().setQuantidade(0);
        } else if (item instanceof Machado) {
            Machado machado = this.stash.getMachados();
            if (machado != null) {
                player.setItem(machado);
            }
        } else if (item instanceof Pocao) {
            Pocao pocao = this.stash.getPocoes();
            if (pocao != null) {
                player.setItem(pocao);
            }
        } else if (item instanceof Chave) {
            Chave chave = this.stash.getChaveT();
            if (chave != null) {
        	player.setItem(chave);
            }
        }
    }

    public Stash getStash() {
        return stash;
    }
    
    public void setPortaN(boolean portaN) {
        this.portaN = portaN;
    }

    public void setPortaL(boolean portaL) {
        this.portaL = portaL;
    }

    public void setPortaS(boolean portaS) {
        this.portaS = portaS;
    }

    public void setPortaO(boolean portaO) {
        this.portaO = portaO;
    }

    public boolean getPortaN() {
        return portaN;
    }

    public boolean getPortaL() {
        return portaL;
    }

    public boolean getPortaS() {
        return portaS;
    }

    public boolean getPortaO() {
        return portaO;
    }

    public Boolean temTroll() {
        return this.troll != null;
    }

    public void setNomePortaN(String nomePortaN) {
        this.nomePortaN = nomePortaN;
    }
    
    public void setNomePortaL(String nomePortaL) {
        this.nomePortaL = nomePortaL;
    }
    
    public void setNomePortaS(String nomePortaS) {
        this.nomePortaS = nomePortaS;
    }
    
    public void setNomePortaO(String nomePortaO) {
        this.nomePortaO = nomePortaO;
    }
    
    public String getNomePortaN() {
        return nomePortaN;
    }

    public String getNomePortaL() {
        return nomePortaL;
    }

    public String getNomePortaS() {
        return nomePortaS;
    }

    public String getNomePortaO() {
        return nomePortaO;
    }
    
    public Troll getTroll() {
        return troll;
    }

    public void setTroll(Troll troll) {
        this.troll = troll;
    }
    
}
