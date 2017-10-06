package bezier;


import org.apache.commons.io.FileUtils;

import java.io.*;


import java.nio.charset.StandardCharsets;
import java.util.List;

class CreateHTML {
    public CreateHTML(String currentFileAbsolutePath, List<Coordinate> coordinateList) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("resources/index.htm").getFile());
        String htmlString= null;
        try {
            htmlString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dataset = convertCoordinateListToString(coordinateList);
        htmlString = htmlString.replace("$name", '"'+currentFileAbsolutePath.substring(1+currentFileAbsolutePath.lastIndexOf('\\')) +'"');
        htmlString = htmlString.replace("$dataset", dataset);
        print(currentFileAbsolutePath,htmlString);

    }
        String convertCoordinateListToString(List<Coordinate> coordinates){
            String result ="[";
            for(Coordinate coordinate:coordinates){
                String s1="[" +coordinate.getX() +" , " + coordinate.getY() + " , " + coordinate.getZ() + "],";
                result=result+s1;
            }
            result=result.substring(0,result.length()-1);
            result+="]";
            return result;
        }

    void print(String absolutePath, String htmlString) {
        String htmlFileName = absolutePath.substring(0, absolutePath.length() - 4) + ".htm";
        PrintStream result = null;
        try {
            result = new PrintStream(new FileOutputStream(htmlFileName));

            result.println(htmlString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            result.flush();
            result.close();
        }

    }
}
