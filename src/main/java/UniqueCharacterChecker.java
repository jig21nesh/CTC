/**
 * Created by jigneshkakkad on 31/03/2016.
 */
public class UniqueCharacterChecker {

    private final int MAX_POSSIBLE_UNIQUE_CHARA = 128;

    public static void main(String[] args) {
        UniqueCharacterChecker uniqueCharacterChecker = new UniqueCharacterChecker();
        System.out.println(uniqueCharacterChecker.doesStringHaveAllUniqueCharacters("TesT"));
    }

    private boolean doesStringHaveAllUniqueCharacters(String f){
        boolean returnValue = false;
        boolean[] CHECKER_ARRAY = new boolean[128];

        if(f == null || f.length() > MAX_POSSIBLE_UNIQUE_CHARA){
            returnValue = false;
        }else{
            for(int index = 0; index < f.length() ; index++){
                int character = f.charAt(index);
                if(CHECKER_ARRAY[character]){
                    returnValue = false;
                    break;
                }else{
                    CHECKER_ARRAY[character] = true;
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

}
