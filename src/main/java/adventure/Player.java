
package adventure;

import java.util.ArrayList;

public class Player {
    
    private String nome;
    private final Ouro ouro;
    private final Diamante diamante;
    private final ArrayList<Object> mochila;

    public Player(String nome) {
        this.nome = nome;
        this.ouro = new Ouro();
        this.ouro.setQuantidade(0);
        this.diamante = new Diamante();
        this.diamante.setQuantidade(0);
        this.mochila = new ArrayList<>();
    }
    
    public void setItem(Object item) {
        mochila.add(item);
    }

    public Integer cargo() {
        return mochila.size();
    }
    
    public Integer itens(Class<?> cls) {
        Integer quantidade = 0;
        for (Object item : this.mochila) {
            if (cls.isInstance(item)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public void drop(String item) {
        Object obj;
        switch (item) {
            case "gold":
                this.ouro.setQuantidade(0);
                break;
            case "diamante":
                this.diamante.setQuantidade(0);
                break;
            case "axe":
                obj = buscaItem(Machado.class);
                if (obj != null) {
                    this.mochila.remove(obj);
                }   break;
            case "potion":
                obj = buscaItem(Pocao.class);
                if (obj != null) {
                    this.mochila.remove(obj);
                }   break;
            default:
                break;
        }
    }

    public Boolean recebeHit() {
        Object item = buscaItem(Pocao.class);
        if (item != null) {
            this.mochila.remove(item);
            return false;
        } else {
            this.ouro.setQuantidade(0);
            return true;
        }
    }

    private Object buscaItem(Class<?> cls) {
        for (Object item : this.mochila) {
            if (cls.isInstance(item)) {
                return item;
            }
        }
        return null;
    }

    public Boolean thrownAxe() {
        Object item = buscaItem(Machado.class);
        if (item != null) {
            this.mochila.remove(item);
            return true;
        } else {
            return false;
        }
    }
    
    public Chave buscaChave(String nome) {
    	Object item;
    	for (int i = 0; i < mochila.size(); i++) {
            item = mochila.get(i);
            if (item instanceof Chave) {
    		if (((Chave)item).getNome().equals(nome)) {
                    return (Chave)item;
    		}
            }
    	}
    	return null;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getNome() {
            return nome;
    }

    public Ouro getOuro() {
        return ouro;
    }
    
    public Diamante getDiamante() {
        return diamante;
    }
    
    public String listaMochila() {
        return mochila.toString();
    }

}
