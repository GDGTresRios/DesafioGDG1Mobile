package br.com.gdgtresrios.centrosulnegocios.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoriaColaborador implements Parcelable {

    private Long id;
    private String nome;
    private String logo;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nome);
        dest.writeString(this.logo);
    }

    public CategoriaColaborador() {
    }

    private CategoriaColaborador(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.nome = in.readString();
        this.logo = in.readString();
    }

    public static final Parcelable.Creator<CategoriaColaborador> CREATOR = new Parcelable.Creator<CategoriaColaborador>() {
        public CategoriaColaborador createFromParcel(Parcel source) {
            return new CategoriaColaborador(source);
        }

        public CategoriaColaborador[] newArray(int size) {
            return new CategoriaColaborador[size];
        }
    };
}
