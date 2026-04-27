package bibliotecaduoc.dto;
public class PokemonResponse {
 
 
    private Long id;
    private String name;
    private int baseHappiness;
 
 
    private Boolean is_legendary;
 
 
    public Long getId() {
        return id;
    }
 
 
    public void setId(Long id) {
        this.id = id;
    }
 
 
    public String getName() {
        return name;
    }
 
 
    public void setName(String name) {
        this.name = name;
    }
 
 
    public Boolean getIs_legendary() {
        return is_legendary;
    }
 
 
    public void setIs_legendary(Boolean isLegendary) {
        this.is_legendary = isLegendary;
    }

    // Método para OBTENER el valor (Getter)
    public int getBaseHappiness() {
        return baseHappiness;   
    }

// Método para ASIGNAR el valor (Setter)
    public void setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }
}
