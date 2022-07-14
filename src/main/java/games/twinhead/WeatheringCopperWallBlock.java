package games.twinhead;

import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WeatheringCopperWallBlock extends WallBlock implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperWallBlock(WeatheringCopper.WeatherState p_154938_, BlockBehaviour.Properties p_154939_) {
        super(p_154939_);
        this.weatherState = p_154938_;
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}
