package work;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xiaobai
 * @Date 2020/12/13 23:53
 * @Version 1.0
 */
public class FirstChange {
    public static void main(String[] args) {
        String s = "fehjblcdljlmckggcigkedfjcejklicihegfhkfbgegjiikcjgfacicaiheibcicmbilbkhhejfdifdehbjelcalcjellkaimhelkjhafcmjhikbgihjlmjclibceecelkaccklbdaifgdflidhidagiahlbjcfbijgeldjgedldbdchkblbdmcdjbjhccikelcmjjbfkhlfekdhbcakgbclgeijbdhmcmemebkgjeeeickifjglmjfjcmjidjgjmijceiikhmmaagebhifhkfhemfeigdlijffcjgmdehjgllkaallheikhghceekhcckfegghdcalalhkhlgikaamladheakecccgafkimibhiafkkkdbflklbhdagdefdgjfihbiakmjbdlhmlhalekjhmjagjahbjflkjiljjbgfhmekifjdejijehfgfjajbbabcgdbhmjmjabfackghfjflcejdcbdfdamcagjbgicbilhdmfclmaemdgkfdgegicikmifbkcckfkkblldhidlmfgckiiceghfcedjbaggmfkkfiacaffkfmliligeadeghklcbhdkgdcgkijklhkbgjicmfiffaaebimmeicaajfikmfbfkemmadgdaiiicjfcfeffmmhhejfgilkalglmfbgckgcdmcbhimfkmhmcccibjcalhfbgmhkckjfmdaamaffheimfihmaifalbamkfeibghkghfbmkghdimmjcmbdbafdfakaideemalgijieifiaakdfbcjggmelclmijhjgjigfhcabgmimcmkbdidhdagbbjeablcdleleijagkaijlgfgiehimklcaidcdeaekeddijlhaijlfclfcflblklgadbdabickelhdlkhefilhcecejkfacfbhcabcjjjhllhelljdmkjgihfebdhbiljijlhclmhgejaecihjfigbdmleebhcaehcgadidbfjjhkkcgddlieidgabhhcghaeehbhghhacgckmkhklchaeeieghjibkmebcifllamgflhikhfkhhmaeekecbcgfblbikgehhdjmedggfdghaafmeghiiiaahgilfibddilfbkdgbjiecibbdekhjbkdhigigffcgmbikhdmbgelgkfidfjkddhfifkdgmihkbdlhlmlkhkbjlhdhgaafkcebcjjaagmkecechalmbheieibihefcllgliamigjgbjcjkgdjeimffhehcjciabgjhgkgmcmemfchiemfldfjimmbeiiiaedkhlkeeijecedclbkhkkekjecfjlilidfigammdgjkgahibdbbkbgjgbabebjcglgfaldgiglilhgfbicchideehgffhfcheamklkkdgfmakhdgmdclejcfgfdlmmbgjamlgchaabelcllalccckajmmkfghaefbebaibdkeegicgmfdgbilhllkfhcgfdeddkfciiibgjhikhaagdkkdmjllalfifjcijhljfebiaflhjdkhmaeejgjkkaelgglefccejidmgkddekjjffcbfjmbmkihmemaibadaihhchdfgiejglmkclcfjgajlgbeillgfbhkgldmfekjbdegjmiddaeaebiaedkdbmciceggbalffddijfccadhhkfgebakkfcmdegdkdbglaeblabjahcjillgmihifbgmiejbefjjecgfkjibejeemcibmcmiifmaiggljgikhiebgijfjafchcjbdmiffjigkmcfhejjagmddjmeckcdhbbdgdcmgfhlcaggjlijjhghihlammgkdekgbkfellfdkcfkigjjecffmgeikafadbfdaadiembbmiadbkbljmkfedllghlhemeaimbamlfcehegbgccfbcjblahdlaakeafmlkjljlkiaglmeideifgdbadjehhmmkfhdkldebegbbiiblkmidlmeejlaemkhfajmidlfcjgiejmmihllbigelbekkfagdcjdbmifdmmchcllmihjlmhblkfcbcjiiaejhgldjmieejhjiadfkfmgamcdlcljbfclkaflhjbeajdkdkjecifikmleblijjedcaccikggjcgidmfjegkbhcacalmbcdgbfjkjajclgdbfcdkemajlajeklieibjhcdheglagfeeagjbacmjdhadgelhemeefikmejlkdcghahfdkhaacghieffcgfgllmdgbkhejkjdcdddhdfdcdidejaekjeclccmedjjmaellmcgfiacbhdfmcdcielcalchbgagelhjjmmkljfagkfjijmddafglimkekjagmhgfiidjefjfmaihhbhhhaafhiekmdkgidjmljfgmgcijbbjmbjiikailalbffjhedbfbbhcbbbicblagibbdamalkiblhblhacdckllbliccmjgedkjbeihhglhbcfaefaimlbjfhmjadlmgdikjjkkghidlfblkdgdbagkldghadhmmckfhkddedlgdfdifghagkdjiklmfbdajfemjcjlamfflgiekmabhcigclbdfefkfmdaffeccgcdflacahhademhjlchabeabbfjfeefhmmbaajmmlmgfhbclkfaihkehjljjhdbkkieikajbbgmfiilkehcliacgggmidlkgjmcjkhjklddijjmjdkejajgllcechmmbfbibdddfgakfmgebkfcbbkjehemckcaefimgfiamhddahklgdhcdgicdmmdfgemlhdcaglcdkeehjkccgcllcldbkggjihdafcfkhkifmkadgkmbgkbgkmilldfhjebdjdfkhmfdhldjmkbcebbbaiemgkihggeebkaibkhajkamfhcbcckgkjbfamlbghhdcehigmehmafalbjedgdgddgjfkfmmeicjlcaajemkjiligbfcbliagicggjclclgidkibkddfgfkclfgdblfebfkcjelghejlejckbgiibedgaebaffcleemmcdgfgjlhdagdmgagiambakabajcjmlifiikckjjfbmafiahmlbhcfegdaekjcgjdbhefkcfdcgkkmlibchbfjbalkbkmgjfbgjlbiffeeabbmgjgbillamjeefklbbibkddcifdakjdlekbkcemkmgdhabdeiccijlicgaecbefmcjeemccegaldfaeafdedbakmiaakjlcbddkkidmkdkdifdgaeflhbkbadgebhhhlaeeajfheamkfkakgmamhaialdmbllbddfidaibffmihfehddlhbemlgdkkikfhkigfkbfjijfiahkfhihkgmblfgidflleameaicgkmimdejkkddddfagfjceffmmkmcffkdfmfjbgjdkbgbelkgjcfhiijlijfeiimcblamiecbmaifejeklfeggfkeiamalhjgklhaellimjelhbgjcghjbfkdjhlmhgkafkkdkkfldbafljgchilbleabgiejfgjhhgcejjjbhkmblkiljbeafhlbdecimdejflhkbkccbkmljldjaihddjmajefjkkdmjkhghdhkhbhmkhjkldlfjjdhdklkheajceelahchhicmkjhekdejdefabaceemjbhimlfjihdmcbhlgihkhgdaibgfbfebadiadkmbjmhgifhefejjgkihkfcbdkjcecjmcifjidfegblklbbabjcfbighkaemgklbidlckebdlgmklifibghalbglmaihkggjcjljgibahghealfhhfiglljdhbffleccdjechchicddkfgimahhmgbjhdlheadfmahelbkhkkgmchljaaekcjhclhghdkebfkcadfajbihemfmjibaidhabdmblakajkddbajemkhebkdkafchalahkijkblmmfakkmdeikhbfhmekakhkmfgjkgljggacmamklbmkdkldmgggajmkaaeimjbffigdjffemcjdfklgbmclkjfhljhfldjkbdfihcjhiaeccafjajldibdlmbkigidecbecbgmlbfcljhieejegclgdeclcfblglgkbmfkhecjgkkkkleeledlmigcijbblhbkeeeifggbkihglgekbjedficgafflgdmhbgajjdajcjalggbciefmbimgabjcbehacagejjbcldalbgfgmiflicdcbabhkmddemieaheldmihcagiledmafagiajgffflfihfghhkkdhlijdgiimbdefehhdkeakddmhedcamjbimigmfajjemlgfdaalelecbifmkjccaefemaijddlmbkmlldhfbklljdedhahajhjmcmaglmbhjagjiifhkdbiehggajddkjchkbeddkahljjgefeffcbdlhkemmecdmbimdmamljhcicfiaambjehjmkjhfajadkeacgcadmcmfkbghbljbfiadkmaacabflejigcialheaibehjblkieaalbclbmhlfekgmggdakhicfaicceggahmidhemaibaiaabfhdjjifbdbkceicgdikhljdhimamghcgjljacdikilhcahedamkgfafhffmlifdeclkekmchmlbigjhijlmfejjjhcdfmjaggfllkdijhadlgfhiiikefglibjclhgedfdmeifeegeelmliefjfjldkdihciclagljcgajdmeijljfdhjkkajfckgaddeaakmjhhahkijhjhfjijamdeakeabfhfifdfkcejjfdgcjjlehkbmmbabiblgjkdhglgjgecfhicildemlaakikfbcdflejfgclmlclbldgldddclhjgdelfjdegbhglmhakdagmgkecdkeihdijijlkckjbammeiafkhmfjieflkcbhiggdjdeaiccaaaaildkmcffkhajefjakgjcglibjcejabfhlddimighmlcggbebbdlhbbjhikagificilmlcbidehkdfeimialijcbfmlgejldbleljgclfhiamhhgcgfjgcjgkmahkchbagfkkakcklefiimhekhckagcmcjadblhljjljdklcgidggmebmfifbfjcgcbhcgehkdikefecmhajjheaecjdiblhhcfcgfgdkjcfgjmhegahfeamclcmjemidkmkjfaecekchmkigdejeeiihlekgiggkcgmblaiblalacddicmehmjhlhmkfleaamamgbdaghdilgcjmfaklbcbldcmikakbmailkkjjlgjiaddfcbcfciladbeedhglebmefjgjfdhebjikbeldkmjldaekgjglbkiagkmlagblideedeehembjdliladifemkgchmlchlbjiaglmbikleclgeefhjlimalibckjgfjfgffhikllghbldhelgjmiifilgkkbdclkggijikbkieldgmggbjcgcfbjaedgclfahajlahllflihbkmakehbgdjbchdajigbdgiefaaadjkkjbjbekdfhaidjfgjgjablkggbagbbhmlkikdhblmfifldbmefjbljgkmdgbbcellefjgmbeladfjbibbjedccaebjakkadcmclihbgcfmjbdldmfcjifcaadibkfkdighjfhgjjaeifdebdkbjhbkibjimmmembkliildfbchbfablcmmjeigemdlkgbgbcfgibekbihkhklhkhkdacjlibkkdlbebbbdkkfdmlbijhammeeeejlfbheicdbcbgeeccfbabjlhadbhbhkmfgfichadjjiakjgagjadkkbggcjkbdciddjmflgedcihmgalkbehccmcagmmifcckcadgclbehhddbcaaiglachgdmhlammfhifahggigbkjblhlbedjldcjkfkglfjkjidciemkjkhkflfldkbhkjgcigdfdlblfkigalkijgmdmiabdiakbcfdldcmkkffihmemakiakfggadcjccckflemckgldjhiblgkhakfccbabfbjidhfmlbkjbedkfmhjjijijfbemffccmccckmhhaadcamfhmikmabkcmklbcikhkhfmdghhihllmekhefbdhgbdhldakljemeggdgabieebcklgkjmcgddhgfmkdbcafgkmhdjfkgdcfalkaadllcmglbkefkllhjghhdfdejbmfkcagaicfmigbdgaldjebejbhmggbkacickeidiimecglbdeeaceedgabballkmjjbjlkjgcjhiibbiflkggcgdemhimegghdjmlcbmhgmhblegehmecflcmmljakfidkmlbhjjdkhmccadkckalkgdiijmbgmceiejkmkabdbmikmlgabheidhbmdkdalhgfigafmccdhkggmbjabkdflckkflacecklaccmlailedldkkbddcjhbhldkimedlhblckbagdbcekmgicjaeemmjiljbiglfggfmgjmabcialkffdamjgfbgmjdfjgafjehdfcgideedgigalffjgcgdkbkfiijiaiglggdbmbflickgamjgghdllfjmhajmgleebdghejihmimlclfidcalfijmlbmejhijfgfjjhechfachlfekgacfmimhbalgcecaijajamchbfaghlljmaihfdajflhmhbgkmjdckdldfgmmcjijebafblikkklbheejfgfhfhmejgfmcakjdfdleejlmaahafgfikhjmlbjbbekbjlkkjflkagmhkfgabcildgfbdckelakmbckeigdddicbkacbfgdejjmegkcflhcajjmhlhkbccfgebhamhgfaggcdjgejcdfcjkcdmbijabjgfbfkgdbagmdflfhfjgaeimajljaamadglkmahjmfbbjhhkmdclcichackjdhmdmegfjdhghmhmkefhklgbjcdbmlblmjmkhcdbdmhhfkhicdlmidbgfcdiakgdmmlldfkafjeaegiifcbkgcbaghbcbcfdmkkalcibdahekgdhkflimafkdekmmdahmhedmakdahjidabhggegfcihkjieeffhefbfjfhemjfbmjfkjidgddimajdimjlljfjahiehafeijhmhilkekdcdiekimaicdfalkgemdjdijfdldajmhgdcmgkcdmmbaiceabkdmejfgdfdcgihibmahmkhmelihggeklgamcecifigekhimdbgkhddlhaeimmgleiikjcjkijfkblgemmefecdahbeckgjjfklmlekkgjlccjfgblkkibljfegbdifcjgdmecglilcmibbdcbficdbheclcejcbagfhgmihamehmligjbmaccimbmejdcabmacfabkkfkacffhhbdechlbgeifjmbkbhdikhahkebafjjkjcejcaciagahjghhjhkeefhjjcfmmahfdkhchhklegjlbbbcdlfcclflgfiibljmbbjhkdjdleegekccaejbhejikkchmmfjejjljiggieabmefajhkgkledgkkejibmbahhehmfdakcfbhemdmemjbgjfgbfgdlflbhkmfackkceeigejdaggfidmfcdaccmmhlmifdddgagmfmejhfbaicccdeijbhefabejkghlmckfdbkjddgdakldccfdgjdghcdhdhjdlkgccehhlbjbkkmeceihgcmiklblkabfmmilicjilgehfhbdihmikgckieggbbbbmmcakkadfbbcffeaijfjmalmlfbdbjdckkfmbefihjiefhfgldmgahmlbgkcdeachjfjccjlcicfleblfdekilcfkgjefflhjckakgkfkdeikhjflddgebmhiiidcdhifhefcdableckklcmiekdgmlcdhjfljlcdbcafekbecaeemgjfcdjhfgeimddmaafihgffmfjmledefikjhefakdiabbkfjkfahhljklagjfbjhjbbcgejbaalhcjdcgfdcbkkjaemmmfgmbdadfmdiaifdmfgfmecdcbkcmbfcgmachffflaicadkjkdekbcidbkcbfdikfdmjlailmgalabejgldcdmfalhakmlgfblikgcaicdmkaiacehchjhkfjflkmfkclibdcljhhgmiecekecdbcemfahfheejmmiljemkdfflfiaijlkilhaeejackljkccllahkfhebmcbimmmbiabaalmdhiebefchkbabgkfmiabdfiaglgbaemmggdebjgbdchakdgekgekflmkllabadegfmegjhkgflelilhghalmmhimelmfcjgiabkbckkkeedbldbdhhmiclfjekmhhhfcfglclgglmifjihfgfgjgalhhbgbahbdfbdmjdlglicjhahljkejkcafdlikahemllljhgkeeiblkhfkjalgflcdlidkdceiefgjlifllchkhdmekimflfakiahbliflilkcmiihhckilkgkhlekfaikkjklbjjfabdfjeiikkibflgaediekjdiaiabileafkehimhbhbmmhcbdgfhiigbdebimecfhllaggdhlmfhijiekaaaffhmimejjcahhckhjmiamgbblkbjdhmmcccidcifmkkjhejicfmegclemfidelicjambgmkjeabffahiemehkglhmfilcbfiglfhfdemebkbmmeeimkadekmelffemllaachaemkikkemehfjkhmdfdkakdgbimedmmckidamlgdfeibkgickhldagfhflmecdmcglifedaeabfckjlkigecfhejlaicfifbffjmejhfbikflickdjadjjfdcglbhljbabefcammkicdlfbiklbjbkjhdcdbfafjleibdhjdcabjlfcddikhjbbchdffjdmdbkmgdafcbjchihjgiiijcgjmjkaahbdhljhfcmljhcaakickjdjifljmhebgkdhlhaadjimhemgbbegcjbgiafbmleklgahdamiegbfkekjkgkejbmlflkkdgkieecgkjhafblgkhhbkdbbfgkggccbgdchflkkcbakhcdkdbiailcighigcdedjekhmhihblgiiciffikaahghababklkegihiflmdahhgjmgbdjgclmjdlgcgeghffmdcahkilbajkggdbdijccmjbbdkhjmefeehfcadgeemghibiiimabmimhhdfffdejjibekdlkjghkhhhaaeemheedhkigcljkfjjmikaaaegjdkiefibcabelijmkgkkchjkaadfhjhackmbjelieefmljfbhkimkifigicmcfiidfcebmeadcagdikcmjcgkcfihdgmkeeigibjidghjmcaeccihdhljcmbdbellbdhfakhmdkjgbcgdkcaefdfkmamfjgkhkdemlmijjfichfkdhejchmmbggedmhifklkckaiciicibcemfhbjbcleljbcdelmbkheafbmddbgdamafgkachfedgahkllkekifldahlmeljkgekljeecmbbidkfhkfkdbkjbljbgbbabmfcbagbebdjiccjgciefkghmclijjhgcjeailbbbbcmjgjcgglggeckdmdmdhhjlgdkijbdefadcklcbjkghahlhafelbbhaeehecbckcdmfkiiadkkcaghbafejclbmbjhddhfibafligideflgdjfleehllfdbacibdbhejbcjldiemhccimgidkmfmgmdihgeelbalfmgghkaecfeijfblghabbkejbmackmkjffbdimccakldblefljbbddbaedjbibhafdjmlflfbgefjcghlgmalbjjbgbgdmbhghajblalbaacdiibhcblijgjcbjbfmedmiahlibbbdidlcelelklflemiemklfdckillga";
        Integer maxLetters =6;
        Integer minSize = 5;
        Integer maxSize = 26;

        String pattern = "";
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        Integer total = 0;
        for (int i = minSize; i <= maxSize; i++) {
            Pattern r = Pattern.compile(getPattern(i));
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                String item = s.substring(j);
                Matcher m = r.matcher(item);
                while (m.find()){
                    arrayList.add(m.group());
                    total ++;
                }
            }
            arrayLists.add(arrayList);
        }
        //过滤重复
        HashMap<String, String> hashMap = new HashMap<>(total);
        for (int n = 0; n < arrayLists.size(); n++) {
            int flag = 0;
            int count = 0;
            int c = 0;
            int b = s.length();
            for (int m = 0; m < arrayLists.get(n).size(); m++) {
                String value = arrayLists.get(n).get(m);
                String key = flag + "" + (flag + value.length()-1);
                if (getDifferentCharacter(value) <= maxLetters){
                    hashMap.put(key, value);
                }
                count ++;
                if (count < b/value.length()){
                    flag = flag + value.length();
                }else{
                    c ++;
                    flag = c;
                    count = 0;
                    b -= 1;
                }
            }
        }
        System.out.println(hashMap);
        System.out.println(getCount(hashMap.values()));
    }

    public static String getPattern(Integer max) {
        String pattern = "";
        for (int i = 0; i < max; i++) {
            pattern += ".";
        }
        return pattern;
    }

    public static Integer getDifferentCharacter(String aString) {
        int[] count = new int[26];
        for (int i = 0; i < aString.length(); i++) {
            count[aString.charAt(i) - 'a'] = 1;
        }
        int item = 0;
        for (int i = 0; i < count.length; i ++){
            if (count[i] == 1){
                item ++;
            }
        }
        return item;
    }

    public static Integer getCount(Collection<String> result){
        Map<String, Integer> map = new HashMap<>(result.size());
        for (String str : result){
            Integer num = map.get(str);
            map.put(str, num == null ? 1 : num + 1);
        }
        ArrayList<Integer> countResult = new ArrayList<>();
        for (Integer v: map.values()){
            countResult.add(v);
        }
        if (countResult.isEmpty()){
            return 0;
        }
        countResult.sort(null);
        return countResult.get(countResult.size() -1);
    }
}
