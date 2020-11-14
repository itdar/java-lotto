package lotto.domain;

import lotto.domain.enums.PickType;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Pick {
    private PickType type;
    private final Set<Integer> balls = new TreeSet<>();

    public Pick() {
    }

    public Pick(PickType pickType, Collection<Integer> balls) {
        setType(pickType);
        setBalls(balls);
    }

    public void setBalls(Collection<Integer> balls) {
        this.balls.addAll(balls);
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public void setType(PickType type) {
        this.type = type;
    }

    public PickType getType() {
        return type;
    }
}
