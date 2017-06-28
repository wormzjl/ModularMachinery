/*******************************************************************************
 * HellFirePvP / Modular Machinery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/ModularMachinery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.modularmachinery.common.machine;

import hellfirepvp.modularmachinery.common.util.handlers.CopyableFluidHandler;
import hellfirepvp.modularmachinery.common.util.handlers.CopyableItemHandler;
import hellfirepvp.modularmachinery.common.util.handlers.IEnergyHandler;

import javax.annotation.Nullable;

/**
 * This class is part of the Modular Machinery Mod
 * The complete source code for this mod can be found on github.
 * Class: MachineComponent
 * Created by HellFirePvP
 * Date: 28.06.2017 / 10:16
 */
public abstract class MachineComponent {

    private final IOType ioType;

    public MachineComponent(IOType ioType) {
        this.ioType = ioType;
    }

    public final IOType getIOType() {
        return ioType;
    }

    public abstract ComponentType getComponentType();

    public static enum IOType {

        INPUT,
        OUTPUT;

        @Nullable
        public static IOType getByString(String name) {
            for (IOType val : values()) {
                if(val.name().equalsIgnoreCase(name)) {
                    return val;
                }
            }
            return null;
        }

    }

    public static enum ComponentType {

        ITEM,
        FLUID,
        ENERGY;

        @Nullable
        public static ComponentType getByString(String name) {
            for (ComponentType val : values()) {
                if(val.name().equalsIgnoreCase(name)) {
                    return val;
                }
            }
            return null;
        }

    }

    public static abstract class ItemBus extends MachineComponent {

        public ItemBus(IOType ioType) {
            super(ioType);
        }

        public abstract CopyableItemHandler getInventory();

        @Override
        public ComponentType getComponentType() {
            return ComponentType.ITEM;
        }

    }

    public static abstract class FluidHatch extends MachineComponent {

        public FluidHatch(IOType ioType) {
            super(ioType);
        }

        public abstract CopyableFluidHandler getTank();

        @Override
        public ComponentType getComponentType() {
            return ComponentType.FLUID;
        }

    }

    public static abstract class EnergyHatch extends MachineComponent {

        public EnergyHatch(IOType ioType) {
            super(ioType);
        }

        public abstract IEnergyHandler getEnergyBuffer();

        @Override
        public ComponentType getComponentType() {
            return ComponentType.ENERGY;
        }

    }

}