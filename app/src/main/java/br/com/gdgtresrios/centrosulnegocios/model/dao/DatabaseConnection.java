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
    private static final Integer DATABASE_VERSION = 4;
    private DateFormat mFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private final List<String> createTableList = new ArrayList<>();

    private final List<String> dropTables = new ArrayList<>();

    private String sdateEventoGuto = "15/07/2015 20:00";
    private Date dateEventoGuto;
    private String sdateEventoRodrigo  = "16/07/2015 20:00";
    private Date dateEventoRodrigo;
    private String sdateEventoBel  = "17/07/2015 20:00";
    private Date dateEventoBel;
    private String sdateEventoRey  = "18/07/2015 20:00";
    private Date dateEventoRey;
    private String sdateEventoMisturaFina  = "15/07/2015 21:30";
    private Date dateEventoMisturaFina;
    private String sdateEventoThiagoPierre  = "16/07/2015 21:30";
    private Date dateEventoThiagoPierre;
    private String sdateEventoLeonardoFabiano  = "16/07/2015 22:30";
    private Date dateEventoLeonardoFabiano;
    private String sdateEventoLarissaJulien  = "17/07/2015 21:30";
    private Date dateEventoLarissaJulien;
    private String sdateEventoRafaelSantos  = "17/07/2015 23:30";
    private Date dateEventoRafaelSantos;
    private String sdateEventoAcustico  = "18/07/2015 21:30";
    private Date dateEventoAcustico;
    private String sdateEventoReplay  = "18/07/2015 23:30";
    private Date dateEventoReplay;
    private String sdateEventoSebraeRodadaCredito  = "16/07/2015 14:00";
    private Date dateEventoSebraeRodadaCredito;
    private String sdateEventoSebraeMei  = "16/07/2015 18:00";
    private Date dateEventoSebraeMei;
    private String sdateEventoSebraeDinheiroInovacao  = "16/07/2015 19:00";
    private Date dateEventoSebraeDinheiroInovacao;
    private String sdateEventoSebraeEmpreendedorismo  = "17/07/2015 18:00";
    private Date dateEventoSebraeEmpreendedorismo;
    private String sdateEventoSebraeNegociacaoEmpresarial  = "17/07/2015 18:00";
    private Date dateEventoSebraeNegociacaoEmpresarial;
    private String sdateEventoSebraeConstruindoIdentidade  = "17/07/2015 19:00";
    private Date dateEventoSebraeConstruindoIdentidade;
    private String sdateEventoSebraeRedesSociais  = "18/07/2015 19:00";
    private Date dateEventoSebraeRedesSociais;
    private String sdateEventoSebraeStarupRJ  = "18/07/2015 14:40";
    private Date dateEventoSebraeStarupRJ;
    private String sdateEventoMostraProjetosTecnologicos  = "18/07/2015 15:30";
    private Date dateEventoMostraProjetosTecnologicos;
    private String sdateEventoEngenheiroComputacao  = "18/07/2015 16:00";
    private Date dateEventoEngenheiroComputacao;
    private String sdateEventoMostraJogos  = "18/07/2015 16:40";
    private Date dateEventoMostraJogos;
    private String sdateEvento50dicas  = "18/07/2015 17:30";
    private Date dateEvento50dicas;
    private String sdateEventoTassio = "15/07/2015 19:00";
    private Date dateEventoTassio;
    private String sdateEventoWanderlei = "16/07/2015 19:00";
    private Date dateEventoWanderlei;
    private String sdateEventoFernando = "16/07/2015 19:30";
    private Date dateEventoFernando;
    private String sdateEventoGui = "17/07/2015 19:00";
    private Date dateEventoGui;
    private String sdateEventoFernando2 = "17/07/2015 21:00";
    private Date dateEventoFernando2;
    private String sdateEventoDavi = "18/07/2015 18:00";
    private Date dateEventoDavi;
    private String sdateEventoAnrafel = "18/07/2015 19:00";
    private Date dateEventoAnrafel;
    private String sdateEventoEmiliano = "18/07/2015 21:00";
    private Date dateEventoEmiliano;



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
        db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Oficinas')");  //3
       // db.execSQL("INSERT INTO " + CategoriaEventoDao.TABLE_NAME + "(" + CategoriaEventoDao.COLUMN_NOME + ") VALUES('Estandes')");   //4

        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Tecnologia')");   //1
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Bandas')");       //2
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Comércio')");     //3
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Educação')");     //4
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Alimentação')");  //5
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Serviços')");     //6
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Construção')");   //7
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Moda')");         //8
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Automotivo')");   //9
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Saúde/Beleza')"); //10
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('Prefeituras')");  //11
        db.execSQL("INSERT INTO " + CategoriaColaboradorDao.TABLE_NAME + "(" + CategoriaColaboradorDao.COLUMN_NOME + ") VALUES('+Outros')");      //12

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Guto Abranches'," +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews...', " +
                "'Âncora do programa Conta Corrente 2ª edição, apresentado pela GloboNews, passou pelas emissoras CNT e Cultura, além do jornal Folha de São Paulo e a revista Veja.'," +
                " 1, 0, 0, 12, 'https://lh3.googleusercontent.com/-5R-LWi3_xvw/VaXg4fo8emI/AAAAAAAAACs/pL9X-YyIUXg/s640-Ic42/GUTO%252520ABRANCHES.png')"); // 1

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Rodrigo Pimentel'," +
                "'Ex-Capitão do BOPE que serviu de inspiração para o Capitão Nascimento...', " +
                "'Ex-Capitão do BOPE, Rodrigo Pimentel, é um dos oficiais que serviu de inspiração para o Capitão Nascimento, interpretado pelo ator Wagner Moura.'," +
                " 1, 0, 0, 12, 'https://lh3.googleusercontent.com/-T9zOly8OMY4/VaXg-o9FMnI/AAAAAAAAADE/GJZ6gnF5PW4/s640-Ic42/RODRIGO%252520PIMENTEL.png')"); //2

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Bel Pesce'," +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros...', " +
                "'Empreendedora, fundadora da FazINOVA  e autora de três livros: A Menina do Vale, Procuram-se Super Herois e A Menina do Vale 2. Foi considerada uma das “100 pessoas mais influentes do Brasil”, pela Revista Época.'," +
                " 1, 0, 0, 12, 'https://lh3.googleusercontent.com/-2RKxOYq6dYA/VaXg9VHQ6FI/AAAAAAAAAC8/ylMfSr-dxPM/s640-Ic42/BEL%252520PESCE.png')"); // 3

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Dr. Robert Rey'," +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro...', " +
                "'Conhecido como Dr. Rey é um cirurgião plástico e apresentador brasileiro e um dos protagonistas do Dr. 90210 (um reality show exibido nos Estados Unidos pelos canais E! Entertainment e People and Arts.'," +
                " 1, 0, 0, 10, 'https://lh3.googleusercontent.com/-ufQTNSJLweI/VaXg61ulaZI/AAAAAAAAAC0/1Dyh5If3IPw/s640-Ic42/DR%252520REY.png')"); // 4

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Mistura Fina'," +
                "'MPB...', " +
                "'A história da banda começa com os integrantes se conhecendo na banda Primeiro de Maio e decidindo formar um trio para tocar músicas de cantores famosos que não são executadas há muito tempo. A banda, mais tarde nomeada de Mistura Fina, é composta por Alex Souza (voz e cajón), Pablo Martins (violão e voz) e Wander Leal (Sopros) e tem tocado músicas que geralmente não são ouvidas com frequência, com novos arranjos e colocando sua personalidade. O seu repertório tem tudo a ver com os seus integrantes já que, foram criados ouvindo essas músicas, o que inclui Djavan, Ivan Lins, Luis Melodia, Tom Jobim, Zeca Pagodinho, entre outros. '," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-d7sKFmn_-Bc/VaXeTzQNtuI/AAAAAAAAACE/AnAKKXjVw_w/s640-Ic42/MISTURA%252520FINA.png')"); // 5

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Thiago Alves & Pierre'," +
                "'MPB...', " +
                "'A dupla se conhecia de eventos regionais, exposições, feiras e festivais, porém estavam sempre em lados um pouco distantes musicalmente. Thiago Alves é músico de formação católica e desde sempre muito eclético, tocou em banda de baile, serestas e passou por várias bandas, com pequena preferência para o Rock Nacional, Mpb e Regional, por influências destes projetos, mas desde sempre muito aberto a novos sons e experiências, com grande capacidade de absorver conteúdo e repertório. Pierre Pureza não nega a origem sambista, tanto que até hoje, nas horas vagas, cada vez menores, participa de projetos ligados a samba e pagode. Com o surgimento das oportunidades em casas de shows adaptadas ao publico da região, barzinhos e festas, a dupla viu oportunidade de criar o projeto para atender esta demanda e apesar de terem trabalhado juntos em outros projetos, Thiago Alves e Pierre, desde Fevereiro de 2015, assumiram essa marca que vem crescendo graças à humildade musical, respeito aos contratantes e publico e capacidade de adaptar o repertório para cada tipo de evento e espectadores. Th&P tem repertório diverso focado na musica Regional, Mpb, Rock Nacional e anos 80, mas também com passagens criativas pelo Reggae, Xote e Samba. Mesmo com o Setlist em mãos cada apresentação é uma viagem diferente, pois a dupla sempre deseja corresponder aos olhares e ao cantar do público e por isso com Thiago Alves, vocalista sempre atento a isso e com vasto recurso de repertório e Pierre, percussionista sempre inquieto e atento, tudo pode acontecer.'," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-txPR_Ju9iJ0/VaXeWVf0M1I/AAAAAAAAACM/kI9A4pju2l8/s640-Ic42/THIAGO%252520ALVES%252520E%252520PIERRE.png')"); // 6

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Leonardo de Freitas e Fabiano'," +
                "'Sertanejo Universitário...', " +
                "'A dupla Leonardo de Freitas e Fabiano, iniciou sua trajetória em meados de 2005 na cidade de Juiz de Fora (MG). Em pouco tempo cativaram um publico em seus shows, tornando-se referencia na região. Rapidamente foram convidados para dividir o palco com grandes nomes da musica sertaneja, como Daniel, Jorge e Matheus, João Bosco e Vinicius, Bruno e Marrone, Michel Teló, Guilherme e Santiago e outros. Com isso ganharam notoriedade no cenário musical.\n" +
                " \n" +
                "Os números mostram. Em 9 anos de carreira, são 2 CDs e 1 DVD gravados, 190 shows no ano, mais de 1 milhão de visualizações na internet. Recentemente gravaram o CLIP da musica “Coração pede socorro” no Castelo de Itaipava (RJ) tornando sucesso imediato. Participaram do quadro “Jogo de Panela” no programa da Ana Maria Braga (TV Globo), além de se apresentarem em eventos no Copacabana Palace, conquistando fãs cariocas.\n" +
                " \n" +
                "Um novo CD e DVD com grandes participações em um repertorio baseado no clássico do sertanejo, são algumas das novidades da dupla para o ano de 2014.\n" +
                " \n" +
                "Leonardo de Freitas: cantor, compositor, arranjador e musico multi-instrumentista (teclado, baixo, guitarra, violão, bateria, viola e acordeon). Dono de um talento admirável.\n" +
                " \n" +
                "Fabiano: cantor, musico (Violão e Guitarra). Extremamente focado na carreira, o sucesso é seu objetivo. '," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-oGpmtZn4Now/VaXeTTwrf3I/AAAAAAAAAB4/9TSfYMwroIs/s640-Ic42/LEONARDO%252520DE%252520FREITAS%252520E%252520FABIANO.png')"); // 7

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Larissa Viana e Julien'," +
                "'Bossa Nova e MPB...', " +
                "' '," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-Tal5cE0qScc/VaXeDIJQr0I/AAAAAAAAABc/mSlIj1TAN-Q/s640-Ic42/LARISSA%252520VIANA%252520E%252520JULIEN.png')"); // 8

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Rafael Santos'," +
                "'Sertanejo Universitário...', " +
                "' '," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-ybZ-61X0zOc/VaXeUFuuJfI/AAAAAAAAACA/IvaSJXPojLI/s640-Ic42/RAFAEL%252520SANTOS.png')"); // 9

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Acústico A3'," +
                "'MPB, Reggae, Pop Rock...', " +
                "'A Banda AC 3 surgiu no fim de 2008, na cidade de Três Rios /RJ, com os músicos Gustavo Cunha, (Voz e Violão), Tiago Cunha (Bateria) e Juninho Hiote (Baixo). Desde então, a banda mescla estilos como MPB, pop/rock, reggae nacional, sertanejo universitário, entre outros; contudo, busca sempre inovações musicais a fim de atender a todos os gostos e a todos que acompanham suas apresentações em sua curta carreira musical. \n" +
                "\n" +
                "Sucesso por onde tocam, vêm deixando sempre sua marca nos bares e festas da região com suas duas principais músicas, frutos do primeiro CD da banda: Fico a Imaginar e Anjo Sol, ambas compostas por eles mesmos e que definem exatamente o espírito do show: alegria e espontaneidade. As duas canções concorreram ao Festival Antense da Canção, no qual a banda ficou em segundo lugar com a música Fico a Imaginar, que posteriormente passou a ser reproduzida na FM 107,3, tal qual Anjo Sol. \n" +
                "\n" +
                "Apesar de jovens, os integrantes são músicos experientes e já participaram de diversos grupos musicais de estilos bem variados, e usam em seus shows o conhecimento adquirido em suas carreiras para divertir e conquistar o público de diferentes idades e gosto musical. \n" +
                "\n" +
                "A banda já abriu shows de artistas como Michel Teló, Os Travessos, Gustavo Lins, entre outros. E se apresentou em diversas festas e exposições das cidades da região, como Três Rios, Paraíba do Sul, Sapucaia, Areal, Levy Gasparian, Juiz de Fora e Cabo Frio, sempre com o lema: ”Se divertir para divertir”.'," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-cNqZrnPnie4/VaXeILXAc9I/AAAAAAAAABk/oRgISGc-K7Q/s640-Ic42/ACUSTICO%252520A3.png')"); // 10

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," +ColaboradorDao.COLUMN_LOGO
                +") VALUES('Banda Replay'," +
                "'Flashback...', " +
                "'Criada em março de 2008, a Banda Replay trouxe   um toque diferente que tem encantado e esquentado as noites do Rio. Com shows e repertório que fogem dos tradicionais apresentados por outras bandas de flashback, a banda toca músicas dos anos 70, 80 e 90 que você adorava e há muito tempo não ouvia, além daquelas que você escuta sempre e quer ouvir de novo.\n" +
                " \n" +
                "Misturando artistas como Erasure e Michael Jackson, Pet Shop Boys e Leo Jaime, Gloria Estefan e Lulu Santos, Metro e Legião Urbana a Replay faz performances com muita energia e carisma, fazendo ferver qualquer pista de dança. Esta diversidade, associada à parceria com a empresa GIG Audio, responsável pela infraestrutura técnica impecável de som e iluminação que acompanha a banda, cria um espetáculo que vai tornar sua festa inesquecível. \n" +
                "  \n" +
                "A Replay é tudo que você espera para seu evento e muito mais, confira!'," +
                " 0, 0, 0, 2, 'https://lh3.googleusercontent.com/-Snf7j2X3wn8/VaXeLBySeJI/AAAAAAAAABs/tVbpfFN3lxE/s640-Ic42/BANDA%252520REPLAY.png')"); // 11

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Sebrae'," +
                "'O Serviço Brasileiro de Apoio às Micro e Pequenas Empresas (Sebrae) é uma entidade privada que promove a competitividade.....', " +
                "'O Serviço Brasileiro de Apoio às Micro e Pequenas Empresas (Sebrae) é uma entidade privada que promove a competitividade e o desenvolvimento sustentável dos empreendimentos de micro e pequeno porte – aqueles com faturamento bruto anual de até R$ 3,6 milhões.\n" +
                "\n" +
                "Há mais de 40 anos, atua com foco no fortalecimento do empreendedorismo e na aceleração do processo de formalização da economia por meio de parcerias com os setores público e privado, programas de capacitação, acesso ao crédito e à inovação, estímulo ao associativismo, feiras e rodadas de negócios.\n" +
                "\n" +
                "As soluções desenvolvidas pelo Sebrae atendem desde o empreendedor que pretende abrir seu primeiro negócio até pequenas empresas que já estão consolidadas e buscam um novo posicionamento no mercado.\n" +
                "\n" +
                "Para garantir o atendimento aos pequenos negócios, o Sebrae atua em todo o território nacional. Onde tem Brasil, tem Sebrae. Além da sede nacional, em Brasília, a instituição conta com pontos de atendimento nas 27 Unidades da Federação, onde são oferecidos cursos, seminários, consultorias e assistência técnica para pequenos negócios de todos os setores.'," +
                " 1, 0, 1, 6, 'https://lh3.googleusercontent.com/-6rlp9fqe4SI/VaXh1FCdsSI/AAAAAAAAAEE/o8m0rFiriNc/s640-Ic42/SEBRAE.png')"); // 12

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Sicomércio'," +
                "'O Sicomércio Três Rios - Sindicato do Comércio Varejista de Três Rios, Paraíba do Sul, Areal, Comendador Levy Gasparian é uma entidade patronal nascida...', " +
                "'O Sicomércio Três Rios - Sindicato do Comércio Varejista de Três Rios, Paraíba do Sul, Areal, Comendador Levy Gasparian é uma entidade patronal nascida em 14/03/1985, do desejo de um grupo de empresários, que via na UNIÃO, uma forma de organizar seus negócios e poder ter voz ativa, perante os diversos órgãos. \n" +
                "\n" +
                "Ao longo desses anos o Sicomércio Três Rios, cresceu e para atender aos anseios e necessidades do segmento que representa, o Sicomércio atua de forma impactante no aprimoramento dos negócios, pois acredita na atitude positiva que irá transformar a relação de produção e consumo na região. A proposta é dar voz aos associados frente à sociedade, construindo um setor respeitado e influente nas decisões políticas e econômicas ao gerar bons serviços, equilíbrio nas vendas e interação com a comunidade e o poder público.'," +
                " 1, 1, 1, 3, 'https://lh3.googleusercontent.com/-81u0kRXI1KI/VaXh2FCJisI/AAAAAAAAAEQ/NsNKK_ZbQII/s640-Ic42/SICOMERCIO%252520TRES%252520RIOS.png')"); // 13

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('CVT Três Rios'," +
                "'Centro Vocacional Tecnológico...', " +
                "'  '," +
                " 0, 1, 0, 4)"); // 14

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Bruno Lemos'," +
                "'Professor USS...', " +
                "'  '," +
                " 1, 0, 0, 12)"); // 15

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('IFRJ - Campus Eng. Paulo de Frontin'," +
                "'Curso Superior de Tecnologia em Jogos Digitais...', " +
                "'O Campus Engenheiro Paulo de Frontin é um dos atuais 11 campi do IFRJ, localizado na região centro-sul fluminense, no município de Engenheiro Paulo de Frontin, mais precisamente no distrito de Sacra Família do Tinguá.  O Campus encontra-se entre as cidades de São Paulo (SP) e Macaé (RJ), a 27 km do Arco metropolitano do Rio de Janeiro, a 34,4 km da Rodovia Presidente Dutra (BR 116) e a 104 km da capital.  Está situado na região Centro Sul do Estado do Rio de Janeiro – Serra do Mar.\n" +
                "\n" +
                "A inauguração do campus se deu em Brasília no dia 1 de fevereiro de 2010 e contou com a presença do então reitor do IFRJ Prof. Dr. Luiz Edmundo Vargas de Aguiar, a atual Presidenta da República Dilma Rousseff, o então presidente da república Luiz Inácio Lula da Silva, o primeiro diretor Prof. Dr. Rodney Cezar de Albuquerque e o então prefeito do município de Eng. Paulo de Frontin, Eduardo Ramos da Paixão.\n" +
                "\n" +
                "No início de 2011 iniciou-se a oferta do primeiro curso técnico do campus, Informática para Internet, funcionando na modalidade concomitante e subseqüente no turno vespertino. O objetivo principal deste curso é o de tornar o aluno capaz de aprender a desenvolver programas de computador voltados para a internet e outras redes de computadores, seguindo as especificações e paradigmas da lógica de programação e das linguagens mais avançadas do mercado. Além disso, são apresentadas ao aluno diversas metodologias, lógica de programação e ferramentas de desenvolvimento de sistemas, para construir soluções que auxiliem no processo de criação de interfaces e aplicativos empregados no comércio e marketing eletrônicos.'," +
                " 1, 0, 0, 12)"); // 16

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Gustavo Guanabara'," +
                "'Gustavo Guanabara é professor carioca desde 1994 e já atuou em todo tipo de segmento...', " +
                "'Gustavo Guanabara é professor carioca desde 1994 e já atuou em todo tipo de segmento. Atuou desde ensino infantil, passando por cursos técnicos, universidades e já coordenou o setor de tutoria para ensino à distância de uma universidade pública. Atualmente, viaja pelo Brasil dando palestras em eventos nacionais e internacionais, como Campus Party, FISL, Latinoware, etc. Para maiores informações sobre seu trabalho, acesse: about.me/guanabara'," +
                " 1, 0, 0, 12)"); // 17

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Vo pitita'," +
                "'', " +
                "''," +
                " 0, 1, 0, 5)"); //18

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Pedras Lara'," +
                "'', " +
                "''," +
                " 0, 1, 0, 7)"); //19

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('GDG Três Rios'," +
                "'Google Developers Group - Três Rios: Desenvolvendo e integrando!', " +
                "'O Google Developers Group Três Rios é um grupo criado para aproximar todos os desenvolvedores que desejam compartilhar e aprender ainda mais.\n" +
                "Venha fazer parte deste time, e nos ajude e apresentar um conteúdo de qualidade!\n" +
                "\n" +
                "GDG Três Rios é um grupo independente, nossas atividades e as opiniões aqui expressas não deve, de forma alguma, ser ligado ao Google, a corporação.'," +
                " 1, 1, 0, 1, 'https://lh3.googleusercontent.com/-HaIgNj056lY/VaZsU4tIHNI/AAAAAAAAAFI/twLPEuxlYj4/s512-Ic42/logo.png')"); //20

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Brasinc'," +
                "'', " +
                "''," +
                " 0, 1, 0, 1)"); //21

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Eco'," +
                "'', " +
                "''," +
                " 0, 1, 0, 1)"); //22

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Rian Design'," +
                "'Inovadores. Somos web designers, designers gráficos, desenhistas, publicitários, músicos, poetas....', " +
                "'Parceiros desde a infância, nossa meta é ir além do que todos possam imaginar. Surpreender até os mais rigorosos olhos.\n" +
                "\n" +
                "Transformar cada traço em um objetivo, cada cor em um novo sentimento, cada site em uma nova pintura para o monitor, mesclando nossas raízes artísticas com o poder de venda do Design. Fazer perfeito.\n" +
                "\n" +
                "Somos simples e completos, rápidos e detalhistas e acreditamos que a simplicidade e o toque artístico em nossos trabalhos nos destacam.\n" +
                "\n" +
                "Mais do que isso, a dedicação e a felicidade de trabalhar com o que trabalhamos. Não uma mera escolha de profissão. Uma escolha de vida. Somos design. É isto.\n" +
                "\n" +
                "\"A simplicidade é o último grau de sofisticação.\" \n" +
                "(Leonardo da Vinci)\n" +
                "\n" +
                "Inovadores. Somos web designers, designers gráficos, desenhistas, publicitários, músicos, poetas, astronautas... Somos o que nossa imaginação nos permitir.'," +
                " 0, 1, 0, 1)"); //23

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Soul Systems'," +
                "'A Soul Systems é uma empresa nova, lançada em 2014, mas alicerçada em mais de dez anos de experiência de seus profissionais...', " +
                "'A Soul Systems é uma empresa nova, lançada em 2014, mas alicerçada em mais de dez anos de experiência de seus profissionais. \n" +
                "Com transparência e comprometimento, a proposta é simples: Solucionar questões do dia-a-dia com inteligência e simplicidade. \n" +
                "Todas as nossas soluções compartilham esse DNA que dá vida e alma aos nossos sistemas.'," +
                " 0, 1, 0, 1)"); //24

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Central do Shop'," +
                "'', " +
                "''," +
                " 0, 1, 0, 1)"); //25

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Zaal'," +
                "'Empresa provedora de soluções completas em tecnologia tem como objetivo otimizar os negócios dos seus clientes com uma plataforma integrada', " +
                "'A ZAAL - empresa provedora de soluções completas em tecnologia tem como objetivo otimizar os negócios dos seus clientes com uma plataforma integrada composta por sistemas de gestão, equipamentos, serviços e treinamentos aplicada às mais diversas necessidades do mercado.\n" +
                "\n" +
                "Todas essas soluções estão aliadas a experiência, conhecimento tecnológico, qualidade nos serviços prestados e o mais importante: o compromisso com a sociedade.'," +
                " 0, 1, 0, 1, 'https://lh3.googleusercontent.com/-0VwvEOiG9qI/VaZsVODy3wI/AAAAAAAAAFE/9UoNNKSrPh0/s912-Ic42/wallpaper_zaal.png')"); //26

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Acesso Tecnologico'," +
                "'', " +
                "''," +
                " 0, 1, 0, 1)"); //27

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Revista On'," +
                "'Romper barreiras, superar-se e oferecer informação de qualidade está entre as prioridades da Revista On. O projeto impresso e ousado teve início no fim de 2010...', " +
                "'Romper barreiras, superar-se e oferecer informação de qualidade está entre as prioridades da Revista On. O projeto impresso e ousado teve início no fim de 2010 em  Três Rios. Um ano depois foi a vez de buscar novos desafios e lançar o conteúdo inteligente em Petrópolis.\n" +
                "\n" +
                "Em 2012 com o objetivo de estar ainda mais próxima do leitor a empresa tem o orgulho de colocar no ar o portal online. Aqui você confere as principais notícias do interior do estado, com a garantia de um produto único feito de forma competente pelos profissionais envolvidos.\n" +
                "\n" +
                "Interatividade, informação, notícias inéditas, promoções e muito mais em um só lugar e em apenas um clique. Agora você pode acessar o site todo dia enquanto aguarda as próximas edições impressas das Revistas On Petrópolis e Três Rios.'," +
                " 0, 1, 0, 1)"); //28

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('API Systems'," +
                "'A API Systems foi fundada em 1998. Uma empresa dedicada a criar soluções em software para várias áreas de mercado. Hoje estamos focados no Comércio Varejista e Soluções Web.', " +
                "'A API Systems foi fundada em 1998. Uma empresa dedicada a criar soluções em software para várias áreas de mercado. Hoje estamos focados no Comércio Varejista e Soluções Web.\n" +
                "\n" +
                "Com uma equipe dedica e preparada, trabalhamos com o que há de mais atual em linguagem de desenvolvimento e banco de dados, oferecendo aos nossos clientes soluções seguras e eficazes.\n" +
                "\n" +
                "Em 2011 lançamos o APIConsult. Uma solução web para gerenciamento de consultórios médicos, que mostra nossa grande aptidão para novidades nesse mercado que está em grande expansão, que é a Computação em Nuvem.'," +
                " 0, 1, 0, 1)"); //29

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Box Music'," +
                "'', " +
                "''," +
                " 0, 1, 0, 8)"); //30

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('J E New Hair'," +
                "'', " +
                "''," +
                " 0, 1, 0, 8)"); //31

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Marcele Semi Jóias'," +
                "'', " +
                "''," +
                " 0, 1, 0, 8)"); //32

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Salada das Marcas   '," +
                "'', " +
                "''," +
                " 0, 1, 0, 8)"); //33

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('M Fashion'," +
                "'', " +
                "''," +
                " 0, 1, 0, 8)"); //34

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('YAMARIOS'," +
                "'Concessionária Yamaha Três Rios...', " +
                "''," +
                " 0, 1, 0, 9)"); //35

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Prefeitura de Petrópolis'," +
                "'', " +
                "''," +
                " 0, 1, 0, 11)"); //36

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Prefeitura de Três Rios'," +
                "'', " +
                "''," +
                " 0, 1, 0, 11, 'https://lh3.googleusercontent.com/-ijyDVsINN3s/VaXh1JvjYaI/AAAAAAAAAD8/ufsogv-MXqA/s640-Ic42/PREFEITURA%252520DE%252520TRES%252520RIOS.png')"); //37

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('UNIMED'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //38

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('SEMEUR'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //39

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Uniodonto'," +
                "'Com mais de 25 anos de atuação, é uma cooperativa de cirurgiões-dentistas que investe na constante atualização de seus profissionais...', " +
                "'Com mais de 25 anos de atuação, é uma cooperativa de cirurgiões-dentistas que investe na constante atualização de seus profissionais, além de garantir a seus clientes a qualidade total dos serviços prestados.\n" +
                "\n" +
                "Encontra-se totalmente de acordo com a nova legislação dos planos de saúde: operadora com registro junto à ANS (Agência Nacional de Saúde Suplementar).'," +
                " 0, 1, 0, 10)"); //40

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('CTO'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //41

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('HCNSC'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //42

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Destaque Design'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //43

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Just Ladies'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //44

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Pro Scan'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //45

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Audioserra'," +
                "'', " +
                "''," +
                " 0, 1, 0, 10)"); //46

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Senac'," +
                "'O Serviço Nacional de Aprendizagem Comercial (Senac) é, desde sua criação, em 1946, o principal agente da educação profissional...', " +
                "'O Serviço Nacional de Aprendizagem Comercial (Senac) é, desde sua criação, em 1946, o principal agente da educação profissional voltado para o Setor do Comércio de Bens, Serviços e Turismo.\n" +
                "\n" +
                "Mais de 55 milhões de atendimentos já foram prestados pelo Senac. A Instituição oferece toda a sua experiência a trabalhadores e empresários, com programações presenciais e a distância, de norte a sul do Brasil.\n" +
                "\n" +
                "São milhares de programações, em centenas de ambientes educacionais de ponta e especializados, como as empresas pedagógicas e as unidades móveis, espalhados em mais de 3 mil municípios, em todos os estados do país e no Distrito Federal.'," +
                " 0, 1, 1, 4, 'https://lh3.googleusercontent.com/-l0ZUk_pCjoY/VaXh1VgdExI/AAAAAAAAAEM/COfo8qMD9bo/s640-Ic42/SENAC.png')"); //47


        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Fecomércio'," +
                "'A Federação do Comércio do Estado do Rio de Janeiro (Fecomércio RJ) tem como objetivo orientar, resguardar, coordenar e representar os interesses...', " +
                "'A Federação do Comércio do Estado do Rio de Janeiro (Fecomércio RJ) tem como objetivo orientar, resguardar, coordenar e representar os interesses dos setores e segmentos ligados ao comércio de bens, serviços e turismo perante as autoridades administrativas e judiciárias. Desta forma, busca contribuir para o desenvolvimento econômico, social e político do estado do Rio de Janeiro, sempre em harmonia com o desenvolvimento sustentável da sociedade, assegurando um ambiente de negócios favorável.\n" +
                " \n" +
                "Com o objetivo de promover a excelência do segmento que representa, a instituição norteia suas ações de acordo com os princípios de livre iniciativa, justa concorrência, gestão eficaz, empreendedorismo, ética e responsabilidade social. Além disso, pensando na qualificação do empresariado, a Fecomércio RJ realiza e apoia seminários, palestras, eventos e feiras regionais, bem como estimula o acesso a novas técnicas de gestão e tecnologia da informação, e edita cadernos técnicos sobre assuntos de interesse.\n" +
                " \n" +
                "O setor reúne mais de 340 mil estabelecimentos no estado do Rio de Janeiro, que respondem por 41,1% do Valor Adicionado Bruto e 62,6% dos estabelecimentos fluminenses, gerando um total de empregos formais superior a 1,8 milhão, que equivalem a 42,1% dos postos de trabalho com carteira assinada no estado. Ao todo, a Fecomércio RJ é formada por 59 sindicatos patronais fluminenses.'," +
                " 0, 0, 1, 6, 'https://lh3.googleusercontent.com/-yKqAGma96kg/VaXhzyJZxwI/AAAAAAAAADk/lZFv4JVKtQg/s640-Ic42/FECOMERCIO.png')"); //48

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('RRDoces'," +
                "'', " +
                "''," +
                " 0, 1, 0, 6)"); //49

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Ótica Pastor'," +
                "'Há 41 anos no mercado, a Ótica Pastor tornou-se referência em produtos e serviços óticos e fotográficos...', " +
                "'A Ótica Pastor tem como sua principal missão garantir excelência em qualidade, servindo com honestidade, transparência e conhecimento técnico para identificar necessidades de nossos clientes, oferecendo sempre os melhores produtos, as melhores marcas e os melhores serviços, tornando-se referencia, além de buscar sempre sua plena satisfação e superando suas expectativas.\n" +
                "Para a Ótica Pastor, mais importante que fidelizar seus clientes, é transformá-los em amigos, e que essa amizade possa ser traduzida em respeito e confiança, servindo sempre de forma exclusiva e personalizada todos os nossos clientes, fornecedores e colaboradores.\n" +
                "Por isso, a Ótica Pastor está sempre inovando, buscando oferecer novos serviços e novos produtos, sempre com a mesma qualidade que você cliente e amigo já conhece.'," +
                " 0, 1, 0, 6)"); //50

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Plan Minas'," +
                "'A Plan Minas nasceu com o intuito de oferecer as classes carentes, auxilio e benefícios voltados à saúde e ao bem estar. Para fazer desse, um sonho possível...', " +
                "'A Plan Minas nasceu com o intuito de oferecer as classes carentes, auxilio e benefícios voltados à saúde e ao bem estar. Para fazer desse, um sonho possível, criamos parcerias com profissionais altamente qualificados a fim de melhor atendermos nossos associados. Hoje, o número de associados que acreditam na Plan Minas, cresce a cada dia, o que demonstra a linha séria e comprometida que temos trabalhado em atenção ao nosso cliente. Somos uma equipe motivada e orgulhosa por atuar em acordo às necessidades de nossos associados, proporcionando uma vida mais saudável e prolongada, além de garantir conforto, tranquilidade e respeito nos momentos difíceis.'," +
                " 0, 1, 0, 6)"); //51

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Claro'," +
                "'', " +
                "''," +
                " 0, 1, 0, 6)"); //52

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('MGO'," +
                "'', " +
                "''," +
                " 0, 1, 0, 6)"); //53

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Eudora'," +
                "'', " +
                "''," +
                " 0, 1, 0, 6)"); //54

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR
                +") VALUES('Estrela H'," +
                "'Representando a marca HONDA, a concessionária Estrela H Motos Ltda., é lider no segmento...', " +
                "'Representando a marca HONDA, a concessionária Estrela H Motos Ltda., é lider no segmento em Cachoeiro de Itapemirim - ES, Venda Nova - ES, Alegre – ES, Campos – RJ, Três Rios – RJ, Valença – RJ e Barra do Piraí – RJ\n" +
                "\n" +
                "Participante ativa nas regiões que atua, onde a conquista e o firmamento da liderança de mercado são trabalhados dia-a-dia, a Estrela H tem como princípios: Ética, Responsabilidade Social, Inovação, Diferenciação, Integridade, Empreendedorismo e desenvolvimento pessoal unido ao profissional. \n" +
                "\n" +
                "Seu empenho na diferenciação está na capacitação das equipes de trabalho, proporcionando inovação no atendimento personalizado e a maior proximidade no relacionamento com seus clientes e no investimento intensivo no desenvolvimento tecnológico, a fim de proporcionar o aumento na sua excelência em qualidade percebida pelo cliente em cada atendimento realizado. Fonte: http://www.estrelah.com.br/'," +
                " 0, 1, 0, 6)"); //55

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Open Brasil'," +
                "'A Open Brasil Promoção e Eventos, com mais de 15 anos de experiência e solidez no mercado é uma das principais empresas promotoras de grandes feiras de negócios e organização de eventos do cenário nacional...', " +
                "'A Open Brasil Promoção e Eventos, com mais de 15 anos de experiência e solidez no mercado é uma das principais empresas promotoras de grandes feiras de negócios e organização de eventos do cenário nacional. Seu sucesso advém da qualidade que oferece ao mercado em suas duas principais linhas de atuação – Feiras de Negócios e Eventos Corporativos, e por sua capacidade para atender a todas as áreas que envolvem a organização de um evento...'," +
                " 0, 0, 1, 6, 'https://lh3.googleusercontent.com/-TE2XBwwgP_Q/VaXh0now2wI/AAAAAAAAAD4/Ap1zn0U5ujo/s640-Ic42/OPEN%252520BRASIL.png')"); //56

        db.execSQL("INSERT INTO " + ColaboradorDao.TABLE_NAME + "(" + ColaboradorDao.COLUMN_NOME + ","
                + ColaboradorDao.COLUMN_DESCRICAO + "," + ColaboradorDao.COLUMN_DESCRICAO_DETALHADA
                + "," + ColaboradorDao.COLUMN_PALESTRANTE + "," + ColaboradorDao.COLUMN_EXPOSITOR
                + "," + ColaboradorDao.COLUMN_PATROCINADOR + "," + ColaboradorDao.COLUMN_FK_CATEGORIA_COLABORADOR + "," + ColaboradorDao.COLUMN_LOGO
                +") VALUES('Latapack-Ball'," +
                "'A Latapack-Ball é uma Joint Venture entre o Grupo PIN (Latapack S/A) e a norte-americana Ball Corporation, tradicional fabricante de embalagens desde 1880 e líder do mercado norte-americano...', " +
                "'A Latapack-Ball é uma Joint Venture entre o Grupo PIN (Latapack S/A) e a norte-americana Ball Corporation, tradicional fabricante de embalagens desde 1880 e líder do mercado norte-americano em latas de alumínio para bebidas. A empresa nasceu com a fábrica de latas de Jacareí (SP), inaugurada em fevereiro de 1997, num terreno de 135 mil m², sendo mais de 40 mil m² de área construída. Atualmente essa planta produz latas 350ml, 473ml e 500ml.\n" +
                "A planta de tampas entrou em produção meses depois, em agosto de 1997, em Simões Filho (BA). Instalada em um terreno de 62 mil m², tem seis mil m² de área construída e atualmente fornece as tampas LOE (Large Opening End) no diâmetro 202.\n" +
                "Em novembro de 2009 teve início a produção da terceira unidade, localizada em Três Rios (RJ), planta responsável pela fabricação da lata de 350 ml e das latas sleeks de 269ml, 310ml e 350ml.\n" +
                "A mais recente unidade fabril da Latapack-Ball, em Alagoinhas tornou-se ativa em março de 2012 com a fabricação das latas 350 ml e 473 ml, e também as sleeks 269 ml e 310 ml. De um total de aproximadamente 122 mil m² são 40 mil m² de área construída. A Latapack-Ball também mantém uma unidade em São Paulo (SP), abrigando a unidade corporativa.\n" +
                "Todas as unidades estão posicionadas entre as mais eficientes e modernas do mundo, usando equipamentos de alta precisão com tecnologia de ponta e seguindo as diretrizes dos princípios básicos da sustentabilidade. A empresa tem como principais objetivos oferecer:\n" +
                "• Produtos de alta qualidade\n" +
                "• O melhor suporte técnico para as operações de seus clientes\n" +
                "• Inovações tecnológicas para criar vantagens competitivas\n" +
                "• Serviços que beneficiem e superem as expectativas de seus clientes'," +
                " 0, 0, 1, 6, 'https://lh3.googleusercontent.com/-hfHboLgc0ew/VaXhzjR8dKI/AAAAAAAAADo/VdZjTT5lBGU/s640-Ic42/LATAPACK%252520BALL.png')"); //57



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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Mistura Fina'," +
                    "'MPB', " +
                    "'A banda Mistura Fina pretende fazer um show temático trazendo à tona a história das músicas que estão tocando.'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Thiago Alves & Pierre'," +
                    "'MPB', " +
                    "'Em especial para o centro Sul Negócios a dupla preparou um repertório focado na musica regional e Mpb, mas também com passagens criativas pelo Reggae, Xote, Samba e Rock Nacional. Mesmo com o Setlist em mãos cada apresentação é uma viagem diferente, pois a dupla sempre deseja corresponder aos olhares e ao cantar do público e por isso com Thiago Alves, vocalista sempre atento a isso e com vasto recurso de repertório e Pierre, percussionista sempre inquieto e atento, tudo pode acontecer.'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Leonardo de Freitas e Fabiano'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Larissa Viana e Julien'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Rafael Santos'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Acústico A3'," +
                    "'MPB, Reggae, Pop Rock', " +
                    "'O Acústico A3 promete mostrar toda sua versatilidade musical em um show empolgante e diferente no próximo sábado. A banda que já é conhecida na região por se apresentar de forma irreverente misturando vários estilos musicais, trará para o público um show eclético recheado de músicas atuais com outras que marcaram época com versões criadas pelos próprios músicos. É um show para todas as gerações curtirem e relembrarem grandes sucessos da música nacional e internacional.'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Show com Banda Replay'," +
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
                    "'Sebrae', " +
                    "'A SESSÃO DE NEGÓCIOS E RODADA DE CRÉDITO é um evento idealizado para criar a maior interatividade possível entre os participantes, micro e pequenas empresas e empresas âncoras,  de forma rápida e objetiva.  Com um modo de participação ágil e dinâmico você se apresentará a todas as empresas âncoras bem como a todas as MPEs participantes da Sessão. A relação com os fornecedores é um elemento crítico para alcance dos resultados empresariais. Este evento será uma grande oportunidade para conhecer novos fornecedores com capacidade de produção e logística para vendas no Rio de Janeiro.\n" +
                    "Rodada de Crédito\n" +
                    "Nesta edição, algumas instituições financeiras estarão presentes no evento (Banco do Brasil, AgeRio, BNDES, Itaú, CEF, Bradesco) com o objetivo de esclarecer dúvidas das  MPEs  em relação a: tomada de crédito/cartões de crédito/investimentos a longo prazo, entre outros.'," +
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
                    "'Sebrae', " +
                    "'A Oficina de Educação Financeira (Finanças Pessoais) tem o objetivo de ampliar o conhecimento dos pequenos negócios quanto à gestão financeira para atingir o equilíbrio e cuidar da sua saúde financeira\n" +
                    " \n" +
                    "Palestrante: Alberto Stassen'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Oficina Tecnológica - Como fazer dinheiro com a inovação'," +
                    "'Sebrae/Sicomércio', " +
                    "'Em tempos de competição acirrada e de restrição do consumo, a inovação pode ser o ponto chave para aumento da lucratividade de uma empresa. Nesta oficina, será discutido de que forma a inovação pode contribuir para melhorar os resultados do negócio.\n" +
                    " \n" +
                    "Palestrante: Ana Paula de Oliveira'," +
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
                    "'Sebrae', " +
                    "'Ser empreendedor pode ser peça chave para oportunidades do mercado. Nesta oficina, discutiremos como o empreendedorismo pode contribuir para que uma pessoa atenda as necessidades do mercado e obtenha sucesso em sua carreira.\n" +
                    " \n" +
                    "Palestrante: Lucia Navarro'," +
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
                    "'Nesta oficina, abordaremos os seguintes temas:\n" +
                    "   •  O processo de negociação;\n" +
                    "   •  Os modelos de negociação;\n" +
                    "   •  O êxito nas negociações;\n" +
                    "   •  As habilidades do negociador;\n" +
                    "   •  As características do negociador.\n" +
                    "Palestrante: Márcia Rosa'," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Construindo a identidade da sua empresa'," +
                    "'Sebrae/Sicomércio', " +
                    "'Ter uma marca forte não é exclusividade das grandes empresas. Nesta oficina você aprenderá a entender o novo consumidor e cuidar da imagem da sua empresa.\n" +
                    " \n" +
                    "Palestrante: Larissa Vizeu '," +
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
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Utilizando as Redes Sociais para aumentar seus clientes'," +
                    "'Sebrae/Sicomércio', " +
                    "'Por meio das mídias sociais sua empresa pode divulgar novos produtos, disseminar promoções, acompanhar sua imagem na internet, ficar atento às tendências de mercado, identificar o que seus clientes procuram, fidelizar seus consumidores, atingir e envolver diretamente seu público-alvo. Nessa oficina, você terá acesso ao que universo das redes sociais, descobrindo como elas podem alavancar novos clientes para sua empresa.\n" +
                    " \n" +
                    "Palestrantes: Ivan Vianna e Victor Sauerbronn'," +
                    dateEventoSebraeRedesSociais.getTime() + ", 3, 12, 60, 'Auditório do Salão Nobre')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoSebraeStarupRJ = mFormatter.parse(sdateEventoSebraeStarupRJ);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Programa Sebrae StartupRJ - Conhecendo as oportunidades'," +
                    "'Sebrae', " +
                    "'Conheça o programa SEBRAE StartupRJ que tem como objetivo formar a nova geração de empreendedores digitais do Estado do Rio de Janeiro, por meio de capacitações e acesso a mercados. O Programa SEBRAE Startup RJ visa preparar estas startups e empreendedores para alçar voos mais altos com seus negócios, através metodologias específicas para estes perfis de negócios.\n" +
                    " \n" +
                    "Palestrante: à confirmar'," +
                    dateEventoSebraeStarupRJ.getTime() + ", 1, 12, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }


        try {
            dateEventoMostraProjetosTecnologicos = mFormatter.parse(sdateEventoMostraProjetosTecnologicos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mostra de Projetos Tecnológicos'," +
                    "'CVT Três Rios', " +
                    "'    '," +
                    dateEventoMostraProjetosTecnologicos.getTime() + ", 3, 14, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoEngenheiroComputacao = mFormatter.parse(sdateEventoEngenheiroComputacao);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('O Engenheiro de Computação e o cenário profissional'," +
                    "'Prof. Bruno Lemos - USS', " +
                    "'    '," +
                    dateEventoEngenheiroComputacao.getTime() + ", 1, 15, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoMostraJogos = mFormatter.parse(sdateEventoMostraJogos);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mostra de Jogos Digitais'," +
                    "'Curso Superior de Tecnologia em Jogos Digitais - IFRJ - Campus Eng. Paulo de Frontin', " +
                    "'O design curricular do curso de Jogos Digitais do IFRJ em Eng. Paulo de Frontin foi minuciosamente planejado mediante realização de audiências públicas, visitas a universidades que disponibilizam o curso e intenso diálogo com os segmentos produtivos. Cada um dos seis períodos letivos será centrado em uma temática: Jogos em 2D, Jogos em 3D, Jogos em Rede, Jogos para Consoles, Jogos para Dispositivos Móveis e Jogos para TV Digital. Ao final do curso o estudante será diplomado Tecnólogo em Jogos Digitais, estando apto a prosseguir seus estudos em nível de pós-graduação e a ingressar no mercado de trabalho em diferentes segmentos da economia, atuando principalmente como Programador de Jogos Digitais, Game Designer, Artista Gráfico ou, ainda, Músico Digital.'," +
                    dateEventoMostraJogos.getTime() + ", 3, 16, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEvento50dicas = mFormatter.parse(sdateEvento50dicas);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('50 dicas para destruir sua carreira usando Redes Sociais'," +
                    "'Com Prof. Gustavo Guanabara', " +
                    "'Todos nós sabemos exatamente como não agir nas redes sociais digitais, certo? Errado! Uma boa parte dos usuários insiste em ter atitudes totalmente fora dos padrões aceitos em qualquer meio de convivência, prejudicando sua vida, seu emprego e até mesmo seu próprio negócio. Essa palestra mostra situações reais que foram coletadas durante anos de pesquisa e apresenta de forma bem-humorada que muitas pessoas e empresas ainda precisam aprender e muito. Venha preparado(a) para dar boas risadas e refletir bastante. Fonte: http://socialmediaweek.org/'," +
                    dateEvento50dicas.getTime() + ", 1, 17, 60, 'Salão Principal')");
        } catch (ParseException e){
            e.printStackTrace();
        }


        try {
            dateEventoTassio = mFormatter.parse(sdateEventoTassio);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Mobile - A revolução em suas mãos'," +
                    "'Com Tássio Auad e Leonardo Procópio', " +
                    "''," +
                    dateEventoTassio.getTime() + ", 1, 20, 60, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoWanderlei = mFormatter.parse(sdateEventoWanderlei);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('GitHub - Controle de Versão'," +
                    "'Com Wanderlei Dos Santos', " +
                    "'O GitHub é um serviço de Web Hosting Compartilhado para projetos que usam o controle de versionamento Git. Nesta palestra do GDG Três Rios você conhecerá um pouco mais sobre essa tecnologia!'," +
                    dateEventoWanderlei.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }


        try {
            dateEventoFernando = mFormatter.parse(sdateEventoFernando);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('PHP - Desvendando os Mitos'," +
                    "'Com Fernando Souza', " +
                    "'O PHP é uma linguagem de programação livre, utilizada principalmente para o desenvolvimento de aplicações web. Nesta palestra do GDG Três Rios serão desvendados alguns mitos sobre esta tecnologia.'," +
                    dateEventoFernando.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoGui = mFormatter.parse(sdateEventoGui);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('HTML 5 - Um Mundo de Possibilidades'," +
                    "'Com Gui Prze, Daniel Oliveira e Henrique Tavares', " +
                    "''," +
                    dateEventoGui.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoDavi = mFormatter.parse(sdateEventoDavi);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Por que Realizar Testes em Softwares'," +
                    "'Com Davi Romeu', " +
                    "'O teste de software é a investigação do software a fim de fornecer informações sobre a sua qualidade em relação ao contexto em que ele deve operar. Isso inclui encontrar seus defeitos. Conhecer mais sobre essa área da Engenharia de Software pode ser um grande diferencial para você e sua empresa.'," +
                    dateEventoDavi.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoAnrafel = mFormatter.parse(sdateEventoAnrafel);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Desenvolvendo Jogos com o Scratch'," +
                    "'Com Anrã Fernandes e Diogo Padilha', " +
                    "'A ideia desta palestra é apresentar o Scratch, uma ferramenta desenvolvida pelo MIT, mostrando algumas das diversas possibilidades de utilizá-lo em sla de aula para incentivar e estimular os estudantes no desenvolvimento do raciocínio lógico.'," +
                    dateEventoAnrafel.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
        } catch (ParseException e){
            e.printStackTrace();
        }

        try {
            dateEventoEmiliano = mFormatter.parse(sdateEventoEmiliano);
            db.execSQL("INSERT INTO " + EventoDao.TABLE_NAME + "(" + EventoDao.COLUMN_NOME + ","
                    + EventoDao.COLUMN_DESCRICAO + "," + EventoDao.COLUMN_DESCRICAO_DETALHADA
                    + "," + EventoDao.COLUMN_DATA_HORA + "," + EventoDao.COLUMN_FK_CATEGORIA_EVENTO
                    + "," + EventoDao.COLUMN_FK_COLABORADOR + "," + EventoDao.COLUMN_DURACAO + ","
                    + EventoDao.COLUMN_LOCAL + ") VALUES('Computação Gráfica - História, Mercado e Referências para aprendizado'," +
                    "'Com Emiliano Silva', " +
                    "'O grande interesse em aimação e computação gráfica tem direcionado meus esforços na pesquisa e captação de materiais de referência para o aprendizado das soluções tecnicas e artísticas utilizadas na criação de curtas e longas de animação.'," +
                    dateEventoEmiliano.getTime() + ", 1, 20, 30, 'Auditório da Ilha de Tecnologia')");
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
