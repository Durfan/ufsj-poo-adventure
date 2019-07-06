
package adventure;

import java.util.ArrayList;
import java.util.Random;

class Stash {
    
    private final Ouro ouro;
    private final Diamante diamante;
    private final ArrayList<Machado> machados;
    private final ArrayList<Pocao> pocoes;
    private Chave chave;
    private Boolean protegido;
    
    Stash() {
        Random rand = new Random();
        
        this.ouro = new Ouro();
        this.ouro.setQuantidade(rand.nextInt(15) + 1);
        this.ouro.setAlcansavel(false);
        
        this.diamante = new Diamante();
        this.diamante.setQuantidade(rand.nextInt(2) + 1);
        this.diamante.setAlcansavel(false);
        
        this.machados = new ArrayList<>();
        if (rand.nextInt(10) < 3) {
            machados.add(new Machado());
        }
        
        this.pocoes = new ArrayList<>();
        if (rand.nextInt(10) < 4) {
            pocoes.add(new Pocao());
        }
 
        this.protegido = false;
        
     	this.chave = new Chave();
        
        if (rand.nextFloat() < 0.5) {
            int aux = rand.nextInt(3);
            switch (aux) {
                case 0:
                    chave.setNome("A");
                    break;
                case 1:
                    chave.setNome("B");
                    break;
                default:
                    chave.setNome("C");
                    break;        	
            }
            chave.setAlcansavel(false);
        }
    }

    public Ouro getOuro() {
        return ouro;
    }

    public Diamante getDiamante() {
        return diamante;
    }

    public Machado getMachados() {
        Machado transfer;
        if (!this.machados.isEmpty()) {
            transfer = this.machados.get(0);
            this.machados.remove(machados.size() - 1);
            return transfer;
        } else {
            return null;
        }
    }
    
    public Boolean alcancaAxe() {
        if (!this.machados.isEmpty()) {
            this.machados.get(0).setAlcansavel(true);
            return true;
        } else {
            return false;
        }
    }

    public Pocao getPocoes() {
        Pocao transfer;
        if (!this.pocoes.isEmpty()) {
            transfer = pocoes.get(0);
            this.pocoes.remove(pocoes.size() - 1);
            return transfer;
        } else {
            return null;
        }
    }
    
    public void alcancaChave(Boolean op) {
    	chave.setAlcansavel(op);
    }

    public Chave getChaveT() {
    	Chave transfer = this.chave;
    	this.chave = new Chave();
    	chave.setNome("0");
    	if(transfer.getAlcansavel()) {
    		return transfer;        
    	}else {
    		return null;
    	}
    }
    
    public void setChave(Chave chave) {
    	this.chave = chave;
    }
    
    public Boolean stashCheio() {
        Boolean cheio = false;
        if (this.ouro.getQuantidade() != 0) {
            cheio = true;
        } else if (this.diamante.getQuantidade() != 0) {
            cheio = true;
        } else if (!this.pocoes.isEmpty()) {
            cheio = true;
        } else if (!this.machados.isEmpty()) {
            cheio = true;
        }

        return cheio;
    }
    
    public Boolean temMachado() {
        return !this.machados.isEmpty();
    }
    
    public Integer viewMachados() {
        return machados.size();
    }
    
    public Integer viewPocoes() {
        return pocoes.size();
    }

    public Boolean getProtegido() {
        return protegido;
    }

    public void setProtegido(Boolean protegido) {
        this.protegido = protegido;
    }
    
    public String viewChaves() {  		
    	return chave.getNome();
    }
    
}
