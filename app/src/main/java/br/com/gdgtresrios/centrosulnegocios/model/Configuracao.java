package br.com.gdgtresrios.centrosulnegocios.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Configuracao implements Parcelable {

    private Long id;
    private String nome;
    private String descricao;
    private String logo;
    private String mapa;
    private String endereco;
    private String telefone;
    private String versao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nome);
        dest.writeString(this.descricao);
        dest.writeString(this.logo);
        dest.writeString(this.mapa);
        dest.writeString(this.endereco);
        dest.writeString(this.telefone);
        dest.writeString(this.versao);
    }

    public Configuracao() {
    }

    private Configuracao(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.nome = in.readString();
        this.descricao = in.readString();
        this.logo = in.readString();
        this.mapa = in.readString();
        this.endereco = in.readString();
        this.telefone = in.readString();
        this.versao = in.readString();
    }

    public static final Parcelable.Creator<Configuracao> CREATOR = new Parcelable.Creator<Configuracao>() {
        public Configuracao createFromParcel(Parcel source) {
            return new Configuracao(source);
        }

        public Configuracao[] newArray(int size) {
            return new Configuracao[size];
        }
    };
}
