/**
 * Created by Jiggy on 12/04/2016.
 */
public class CompressionFinder {

    public static void main(String[] args) {
        CompressionFinder compressionFinder = new CompressionFinder();
        String compressedString = compressionFinder.doTheCompression("aabcccccaaa");
        System.out.println(compressedString);
    }

    private String doTheCompression(String string){
        String returnString = null;

        char theKey = string.charAt(0);
        int theCountOfTheKey = 1;
        for(int index = 1; index < string.length() ; ++index){
            char c = string.charAt(index);
            if(c == theKey){
                theCountOfTheKey += 1;
            }else{
                if(returnString == null){
                    returnString = String.valueOf(theKey) + String.valueOf(theCountOfTheKey);
                }else{
                    returnString += String.valueOf(theKey) + String.valueOf(theCountOfTheKey);
                }
                theCountOfTheKey = 1;
                theKey = string.charAt(index);
            }
        }
        returnString += String.valueOf(theKey) + String.valueOf(theCountOfTheKey);
        if(this.isTheCompressedStringSmaller(returnString, string)){
            return returnString;
        }else{
            return string;
        }

    }

    private boolean isTheCompressedStringSmaller(String compressedString, String originalString){
        return compressedString.length() < originalString.length();
    }
}
