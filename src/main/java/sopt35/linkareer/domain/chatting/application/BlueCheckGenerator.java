package sopt35.linkareer.domain.chatting.application;

import java.util.concurrent.ThreadLocalRandom;
import sopt35.linkareer.annotation.Generator;

@Generator
public class BlueCheckGenerator {

    public boolean pickBlueChecked() {
        return ThreadLocalRandom.current().nextDouble(0, 1) > 0.5;
    }
}
