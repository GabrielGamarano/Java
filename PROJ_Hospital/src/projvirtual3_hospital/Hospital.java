package projvirtual3_hospital;

public class Hospital {
    private String nomeHospital;
    private int    leitosDisponiveis;
    private int    leitosOcupados;

    public Hospital(String nomeHospital, int leitosDisponiveis, int leitosOcupados) {
        this.nomeHospital = nomeHospital;
        this.leitosDisponiveis = leitosDisponiveis;
        this.leitosOcupados = leitosOcupados;
    }
    public int leitosDisponiveis(){
        return leitosDisponiveis - leitosOcupados;
    }
    
    public String toString(){
        return (nomeHospital + " - "+leitosDisponiveis() + " Leitos");
    }
    
    public String getNomeHospital() {
        return nomeHospital;
    }

    public int getLeitosDisponiveis() {
        return leitosDisponiveis;
    }

    public int getLeitosOcupados() {
        return leitosOcupados;
    }
    
    

    
}
