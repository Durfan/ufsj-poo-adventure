package adventure;

class Porta extends Sala {
    
    private String nome;
    private Sala atual;
    private Sala proxima;
    private Boolean locked;
    
    Porta(Sala atual, Sala proxima) {
        this.atual = atual;
        this.proxima = proxima;
    }
    
    
    public Sala proximaSala(Sala atual) {
        if (atual.equals(this.atual)) {
            return this.proxima;
        } else {
            return this.atual;
        }
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Sala getAtual() {
        return atual;
    }

    public Sala getProxima() {
        return proxima;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
