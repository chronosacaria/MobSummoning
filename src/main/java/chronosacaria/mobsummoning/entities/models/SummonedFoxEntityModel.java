package chronosacaria.mobsummoning.entities.models;

import chronosacaria.mobsummoning.entities.SummonedFoxEntity;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SummonedFoxEntityModel<T extends SummonedFoxEntity> extends AnimalModel<T> {
    public final ModelPart head;
    private final ModelPart rightEar;
    private final ModelPart leftEar;
    private final ModelPart nose;
    private final ModelPart torso;
    private final ModelPart rightBackLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart tail;

    public SummonedFoxEntityModel() {
        super(true, 8.0F, 3.35F);
        this.textureWidth = 48;
        this.textureHeight = 32;
        this.head = new ModelPart(this, 1, 5);
        this.head.addCuboid(-3.0F, -2.0F, -5.0F, 8.0F, 6.0F, 6.0F);
        this.head.setPivot(-1.0F, 16.5F, -3.0F);
        this.rightEar = new ModelPart(this, 8, 1);
        this.rightEar.addCuboid(-3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F);
        this.leftEar = new ModelPart(this, 15, 1);
        this.leftEar.addCuboid(3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F);
        this.nose = new ModelPart(this, 6, 18);
        this.nose.addCuboid(-1.0F, 2.01F, -8.0F, 4.0F, 2.0F, 3.0F);
        this.head.addChild(this.rightEar);
        this.head.addChild(this.leftEar);
        this.head.addChild(this.nose);
        this.torso = new ModelPart(this, 24, 15);
        this.torso.addCuboid(-3.0F, 3.999F, -3.5F, 6.0F, 11.0F, 6.0F);
        this.torso.setPivot(0.0F, 16.0F, -6.0F);
        float f = 0.001F;
        this.rightBackLeg = new ModelPart(this, 13, 24);
        this.rightBackLeg.addCuboid(2.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.001F);
        this.rightBackLeg.setPivot(-5.0F, 17.5F, 7.0F);
        this.leftBackLeg = new ModelPart(this, 4, 24);
        this.leftBackLeg.addCuboid(2.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.001F);
        this.leftBackLeg.setPivot(-1.0F, 17.5F, 7.0F);
        this.rightFrontLeg = new ModelPart(this, 13, 24);
        this.rightFrontLeg.addCuboid(2.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.001F);
        this.rightFrontLeg.setPivot(-5.0F, 17.5F, 0.0F);
        this.leftFrontLeg = new ModelPart(this, 4, 24);
        this.leftFrontLeg.addCuboid(2.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.001F);
        this.leftFrontLeg.setPivot(-1.0F, 17.5F, 0.0F);
        this.tail = new ModelPart(this, 30, 0);
        this.tail.addCuboid(2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 5.0F);
        this.tail.setPivot(-4.0F, 15.0F, -1.0F);
        this.torso.addChild(this.tail);
    }

    public void animateModel(T foxEntity, float f, float g, float h) {
        this.torso.pitch = 1.5707964F;
        this.tail.pitch = -0.05235988F;
        this.rightBackLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
        this.leftBackLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
        this.rightFrontLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
        this.leftFrontLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
        this.head.setPivot(-1.0F, 16.5F, -3.0F);
        this.head.yaw = 0.0F;
        this.rightBackLeg.visible = true;
        this.leftBackLeg.visible = true;
        this.rightFrontLeg.visible = true;
        this.leftFrontLeg.visible = true;
        this.torso.setPivot(0.0F, 16.0F, -6.0F);
        this.torso.roll = 0.0F;
        this.rightBackLeg.setPivot(-5.0F, 17.5F, 7.0F);
        this.leftBackLeg.setPivot(-1.0F, 17.5F, 7.0F);
    }

    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.torso, this.rightBackLeg, this.leftBackLeg, this.rightFrontLeg, this.leftFrontLeg);
    }

    public void setAngles(T foxEntity, float f, float g, float h, float i, float j) {

        float l;
        if (foxEntity.isInSneakingPose()) {
            l = MathHelper.cos(h) * 0.01F;
            this.torso.yaw = l;
            this.rightBackLeg.roll = l;
            this.leftBackLeg.roll = l;
            this.rightFrontLeg.roll = l / 2.0F;
            this.leftFrontLeg.roll = l / 2.0F;
        }
    }
}