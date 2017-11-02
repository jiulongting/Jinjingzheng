import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import javax.sound.sampled.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jinjingzheng {
    private static Screen screen;

    public static void main(String[] args) throws FindFailed, InterruptedException {

        screen = new Screen();
        ImagePath.add("C:\\Users\\zwb\\IdeaProjects\\Jinjingzheng\\src\\main\\resources");
        process();
    }

    private static void process() throws FindFailed, InterruptedException {
        String[] btns = new String[]{"1509607492855","1509607506517","1509607566351"};

        for (String b:btns) {
            screen.wait(b+".png",3000);
            screen.click(b+".png");
            Thread.sleep(2000);
        }

        Match match = screen.wait("1509607619583.png",3000);

        if(match.isValid())
        {
            System.out.println("人多重试");
            screen.wait("1509607633145.png");
            screen.click("1509607633145.png");
            process();
        }
        else
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            System.out.println("进京证可以申请啦 "+simpleDateFormat.format(new Date()));
        }
    }
}
