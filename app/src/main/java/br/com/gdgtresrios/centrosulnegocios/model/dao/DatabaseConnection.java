package br.com.gdgtresrios.centrosulnegocios.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.gdgtresrios.centrosulnegocios.model.CategoriaColaborador;
import br.com.gdgtresrios.centrosulnegocios.model.CategoriaEvento;

public class DatabaseConnection extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "centrosulnegocios";
    private static final Integer DATABASE_VERSION = 1;
    private DateFormat mFormatter = new SimpleDateFormat("dd/MM/yyyy");

    private final List<String> createTableList = new ArrayList<>();

    private final List<String> dropTables = new ArrayList<>();

    private String sdateEventoGuto = "15/07/2015";
    private Date dateEventoGuto;
    private String sdateEventoRodrigo  = "16/07/2015";
    private Date dateEventoRodrigo;
    private String sdateEventoBel  = "17/07/2015";
    private Date dateEventoBel;
    private String sdateEventoRey  = "18/07/2015";
    private Date dateEventoRey;
    private String sdateEventoMisturaFina  = "15/07/2015";
    private Date dateEventoMisturaFina;
    private String sdateEventoThiagoPierre  = "16/07/2015";
    private Date dateEventoThiagoPierre;
    private String sdateEventoLeonardoFabiano  = "16/07/2015";
    private Date dateEventoLeonardoFabiano;
    private String sdateEventoLarissaJulien  = "17/07/2015";
    private Date dateEventoLarissaJulien;
    private String sdateEventoRafaelSantos  = "17/07/2015";
    private Date dateEventoRafaelSantos;
    private String sdateEventoAcustico  = "18/07/2015";
    private Date dateEventoAcustico;
    private String sdateEventoReplay  = "18/07/2015";
    private Date dateEventoReplay;
    private String sdateEventoSebraeRodadaCredito  = "16/07/2015";
    private Date dateEventoSebraeRodadaCredito;
    private String sdateEventoSebraeMei  = "16/07/2015";
    private Date dateEventoSebraeMei;
    private String sdateEventoSebraeDinheiroInovacao  = "16/07/2015";
    private Date dateEventoSebraeDinheiroInovacao;
    private String sdateEventoSebraeEmpreendedorismo  = "17/07/2015";
    private Date dateEventoSebraeEmpreendedorismo;
    private String sdateEventoSebraeNegociacaoEmpresarial  = "17/07/2015";
    private Date dateEventoSebraeNegociacaoEmpresarial;
    private String sdateEventoSebraeConstruindoIdentidade  = "17/07/2015";
    private Date dateEventoSebraeConstruindoIdentidade;
    private String sdateEventoSebraeRedesSociais  = "18/07/2015";
    private Date dateEventoSebraeRedesSociais;



    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CategoriaEventoDao.CREATE_TABLE);
        db.execSQL(CategoriaColaboradorDao.CREATE_TABLE);
        db.execSQL(ColaboradorDao.CREATE_TABLE);
        db.execSQL(EventoDao.CREATE_TABLE);
        db.execSQL(ConfiguracaoDao.CREATE_TABLE);

        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Palestras')");  //1
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Shows')");      //2
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Workshops')");  //3
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Estandes')");   //4

        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Informática')");  //1
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Bandas')");       //2
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Comércio')");     //3
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Turismo')");      //4
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Palestrante')");  //5
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Empreendedorismo')");  //6

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('GUTO ABRANCHES'," +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews...', " +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews, passou pelas emissoras CNT e Cultura, além do jornal Folha de São Paulo e a revista Veja.'," +
                " 1, 0, 0, 5)"); // 1

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('RODRIGO PIMENTEL'," +
                "'Ex-Capitão do BOPE que serviu de inspiração para o Capitão Nascimento...', " +
                "'Ex-Capitão do BOPE, Rodrigo Pimentel, é um dos oficiais que serviu de inspiração para o Capitão Nascimento, interpretado pelo ator Wagner Moura.'," +
                " 1, 0, 0, 5)"); //2

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('BEL PESCE'," +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros...', " +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros: A Menina do Vale, Procuram-se Super Herois e A Menina do Vale 2. Foi considerada uma das “100 pessoas mais influentes do Brasil”, pela Revista Época.'," +
                " 1, 0, 0, 5)"); // 3

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('DR. ROBERT REY'," +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro...', " +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro e um dos protagonistas do Dr. 90210 (um reality show exibido nos Estados Unidos pelos canais E! Entertainment e People and Arts.'," +
                " 1, 0, 0, 5)"); // 4

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Mistura Fina'," +
                "'MPB...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 5

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Thiago Alves & Pierre'," +
                "'MPB...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 6

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Leonardo de Freitas e Fabiano'," +
                "'Sertanejo Universitário...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 7

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Larissa Viana e Julien'," +
                "'Bossa Nova e MPB...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 8

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Rafael Santos'," +
                "'Sertanejo Universitário...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 9

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Acústico A3'," +
                "'MPB, Reggae, Pop Rock...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 10

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Banda Replay'," +
                "'Flashback...', " +
                "' '," +
                " 0, 0, 0, 2)"); // 11

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Sebrae'," +
                "'  ', " +
                "'  '," +
                " 1, 0, 1, 6)"); // 12

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Sicomércio'," +
                "'  ', " +
                "'  '," +
                " 1, 1, 1, 3)"); // 12


        try {
            dateEventoGuto = mFormatter.parse(sdateEventoGuto);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL +") VALUES('Comunicação Eficaz em Tempos de Crise'," +
                    "'Mudança de atitude perante as dificuldades encontradas através da comunicação eficaz.', " +
                    "'Mudança de atitude perante as dificuldades encontradas através da comunicação eficaz; Novas estratégias para aperfeiçoar a comunicação e enfrentar as adversidades no momento de crise; Aperfeiçoar a comunicação com público interno e clientes para obtenção de resultados.'," +
                    dateEventoGuto.getTime() + ", 1, 1, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRodrigo = mFormatter.parse(sdateEventoRodrigo);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Construindo uma Tropa de Elite'," +
                    "'...despertar as pessoas para superar os “desafios” do ambiente competitivo de trabalho...', " +
                    "'A palestra tem como objetivo despertar as pessoas para superar os “desafios” do ambiente competitivo de trabalho e para focar a liderança sob o aspecto dos “homens de preto” do BOPE.'," +
                    dateEventoRodrigo.getTime() + ", 1, 2, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoBel = mFormatter.parse(sdateEventoBel);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Uma Jornada Empreendedora'," +
                    "'Na palestra, Bel Pesce conta, com muita leveza e humor, sua extraordinária trajetória de carreira.', " +
                    "'Na palestra, Bel Pesce conta, com muita leveza e humor, sua extraordinária trajetória de carreira. Cada vitória é cheia de obstáculos, que Bel consegue atravessar, usando atitudes empreendedoras e  ideias inovadoras. Através de várias histórias envolventes, ela mostra como humildade, gentileza, perseverança, e determinação foram fatores importantes para seu sucesso.'," +
                    dateEventoBel.getTime() + ", 1, 3, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRey = mFormatter.parse(sdateEventoRey);

            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Obtendo Sucesso, Cuidando da Saúde, Bem Estar e Beleza'," +
                    "'A palestra tem como foco: motivação, autoestima, beleza, estética...', " +
                    "'A palestra tem como foco: motivação, autoestima, beleza, estética, comportamento, nutrição, estilo de vida e cirurgia - A importância de homens e mulheres em estar bem com o corpo e mente, como forma  de obtenção de sucesso na vida pessoal e profissional.'," +
                    dateEventoRey.getTime() + ", 1, 4, 30, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoMisturaFina = mFormatter.parse(sdateEventoMisturaFina);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mistura Fina'," +
                    "'MPB', " +
                    "'    '," +
                    dateEventoMisturaFina.getTime() + ", 2, 5, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoThiagoPierre = mFormatter.parse(sdateEventoThiagoPierre);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Thiago Alves & Pierre'," +
                    "'MPB', " +
                    "'    '," +
                    dateEventoThiagoPierre.getTime() + ", 2, 6, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoLeonardoFabiano = mFormatter.parse(sdateEventoLeonardoFabiano);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Leonardo de Freitas e Fabiano'," +
                    "'Sertanejo Universitário', " +
                    "'    '," +
                    dateEventoLeonardoFabiano.getTime() + ", 2, 7, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoLarissaJulien = mFormatter.parse(sdateEventoLarissaJulien);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Larissa Viana e Julien'," +
                    "'Bossa Nova e MPB', " +
                    "'    '," +
                    dateEventoLarissaJulien.getTime() + ", 2, 8, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoRafaelSantos = mFormatter.parse(sdateEventoRafaelSantos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Rafael Santos'," +
                    "'Sertanejo Universitário', " +
                    "'    '," +
                    dateEventoRafaelSantos.getTime() + ", 2, 9, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoAcustico = mFormatter.parse(sdateEventoAcustico);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Acústico A3'," +
                    "'MPB, Reggae, Pop Rock', " +
                    "'    '," +
                    dateEventoAcustico.getTime() + ", 2, 10, 60, 'Palco MPB')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoReplay = mFormatter.parse(sdateEventoReplay);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Banda Replay'," +
                    "'Flashback', " +
                    "'    '," +
                    dateEventoReplay.getTime() + ", 2, 11, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeRodadaCredito = mFormatter.parse(sdateEventoSebraeRodadaCredito);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Sessão de Negócios e Rodada de Crédito'," +
                    "'    ', " +
                    "'    '," +
                    dateEventoSebraeRodadaCredito.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeMei = mFormatter.parse(sdateEventoSebraeMei);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Finanças Pessoais MEI, Empreendedores e Empresários'," +
                    "'    ', " +
                    "'    '," +
                    dateEventoSebraeMei.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeDinheiroInovacao = mFormatter.parse(sdateEventoSebraeDinheiroInovacao);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Finanças Pessoais MEI, Empreendedores e Empresários'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeDinheiroInovacao.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeEmpreendedorismo = mFormatter.parse(sdateEventoSebraeEmpreendedorismo);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Empreendedorismo e as oportunidades do mercado'," +
                    "'    ', " +
                    "'    '," +
                    dateEventoSebraeEmpreendedorismo.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeNegociacaoEmpresarial = mFormatter.parse(sdateEventoSebraeNegociacaoEmpresarial);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Negociação Empresarial - formando alianças e parcerias'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeNegociacaoEmpresarial.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeConstruindoIdentidade = mFormatter.parse(sdateEventoSebraeConstruindoIdentidade);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Posicionamento, Marcas e Conceitos - Construindo a identidade da sua empresa'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeConstruindoIdentidade.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeRedesSociais = mFormatter.parse(sdateEventoSebraeRedesSociais);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Utilizando as Redes Sociais (Facebook) para aumentar seus clientes'," +
                    "'Sebrae/Sicomércio', " +
                    "'    '," +
                    dateEventoSebraeRedesSociais.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CategoriaEventoDao.DROP_TABLE);
        db.execSQL(CategoriaColaboradorDao.DROP_TABLE);
        db.execSQL(ColaboradorDao.DROP_TABLE);
        db.execSQL(EventoDao.DROP_TABLE);
        db.execSQL(ConfiguracaoDao.DROP_TABLE);
        onCreate(db);
    }
}
