package sopt35.linkareer.domain.chatting.application;

import java.util.Random;
import sopt35.linkareer.annotation.Generator;

@Generator
public class BlueCheckGenerator {

    private final Random random = new Random();

    public boolean pickBlueChecked() {
        return random.nextDouble(0, 1) > 0.5;
    }
}
