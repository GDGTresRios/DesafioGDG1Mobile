package br.com.gdgtresrios.centrosulnegocios.model;


import android.os.Parcel;
import android.os.Parcelable;

public class CategoriaEvento implements Parcelable {

    private Long id;
    private String nome;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.nome);
    }

    public CategoriaEvento() {
    }

    private CategoriaEvento(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.nome = in.readString();
    }

    public static final Parcelable.Creator<CategoriaEvento> CREATOR = new Parcelable.Creator<CategoriaEvento>() {
        public CategoriaEvento createFromParcel(Parcel source) {
            return new CategoriaEvento(source);
        }

        public CategoriaEvento[] newArray(int size) {
            return new CategoriaEvento[size];
        }
    };
}
