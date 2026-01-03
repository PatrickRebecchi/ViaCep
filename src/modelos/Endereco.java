package modelos;

public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ddd;
    private boolean erro;

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getDdd() {
        return ddd;
    }

    public boolean isErro() {
        return erro;
    }

    @Override
    public String toString() {
        return """
                ===== ENDEREÇO =====
                CEP: %s
                Logradouro: %s
                Bairro: %s
                Cidade: %s - %s
                Estado: %s
                Região: %s
                DDD: %s
                ====================
                """.formatted(
                cep,
                logradouro,
                bairro,
                localidade,
                uf,
                estado,
                regiao,
                ddd
        );
    }
}