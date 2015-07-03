package br.com.gdgtresrios.centrosulnegocios.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Evento implements Parcelable {

    private Long id;
    private String nome;
    private String descricao;
    private String descricaoDetalhada;
    private Date dataHora;
    private Date duracao;
    private String local;
    private CategoriaEvento categoriaEvento;
    private Colaborador colaborador;

    public Evento() {
    }

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

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public CategoriaEvento getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.nome);
        dest.writeString(this.descricao);
        dest.writeString(this.descricaoDetalhada);
        dest.writeLong(dataHora != null ? dataHora.getTime() : -1);
        dest.writeLong(duracao != null ? duracao.getTime() : -1);
        dest.writeString(this.local);
        dest.writeParcelable(this.categoriaEvento, flags);
        dest.writeParcelable(this.colaborador, flags);
    }

    private Evento(Parcel in) {
        this.id = in.readLong();
        this.nome = in.readString();
        this.descricao = in.readString();
        this.descricaoDetalhada = in.readString();
        long tmpDataHora = in.readLong();
        this.dataHora = tmpDataHora == -1 ? null : new Date(tmpDataHora);
        long tmpDuracao = in.readLong();
        this.duracao = tmpDuracao == -1 ? null : new Date(tmpDuracao);
        this.local = in.readString();
        this.categoriaEvento = in.readParcelable(CategoriaEvento.class.getClassLoader());
        this.colaborador = in.readParcelable(Colaborador.class.getClassLoader());
    }

    public static final Parcelable.Creator<Evento> CREATOR = new Parcelable.Creator<Evento>() {
        public Evento createFromParcel(Parcel source) {
            return new Evento(source);
        }

        public Evento[] newArray(int size) {
            return new Evento[size];
        }
    };
}
