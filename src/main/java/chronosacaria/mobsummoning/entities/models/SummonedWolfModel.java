package chronosacaria.mobsummoning.entities.models;

import chronosacaria.mobsummoning.entities.SummonedWolfEntity;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.TintableAnimalModel;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SummonedWolfModel<T extends SummonedWolfEntity> extends TintableAnimalModel<T> {
    private final ModelPart head;
    private final ModelPart field_20788;
    private final ModelPart torso;
    private final ModelPart rightBackLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart tail;
    private final ModelPart field_20789;
    private final ModelPart neck;

    public SummonedWolfModel() {
        float f = 0.0F;
        float g = 13.5F;
        this.head = new ModelPart(this, 0, 0);
        this.head.setPivot(-1.0F, 13.5F, -7.0F);
        this.field_20788 = new ModelPart(this, 0, 0);
        this.field_20788.addCuboid(-2.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F);
        this.head.addChild(this.field_20788);
        this.torso = new ModelPart(this, 18, 14);
        this.torso.addCuboid(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F);
        this.torso.setPivot(0.0F, 14.0F, 2.0F);
        this.neck = new ModelPart(this, 21, 0);
        this.neck.addCuboid(-3.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, 0.0F);
        this.neck.setPivot(-1.0F, 14.0F, 2.0F);
        this.rightBackLeg = new ModelPart(this, 0, 18);
        this.rightBackLeg.addCuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.rightBackLeg.setPivot(-2.5F, 16.0F, 7.0F);
        this.leftBackLeg = new ModelPart(this, 0, 18);
        this.leftBackLeg.addCuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.leftBackLeg.setPivot(0.5F, 16.0F, 7.0F);
        this.rightFrontLeg = new ModelPart(this, 0, 18);
        this.rightFrontLeg.addCuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.rightFrontLeg.setPivot(-2.5F, 16.0F, -4.0F);
        this.leftFrontLeg = new ModelPart(this, 0, 18);
        this.leftFrontLeg.addCuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.leftFrontLeg.setPivot(0.5F, 16.0F, -4.0F);
        this.tail = new ModelPart(this, 9, 18);
        this.tail.setPivot(-1.0F, 12.0F, 8.0F);
        this.field_20789 = new ModelPart(this, 9, 18);
        this.field_20789.addCuboid(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.tail.addChild(this.field_20789);
        this.field_20788.setTextureOffset(16, 14).addCuboid(-2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F);
        this.field_20788.setTextureOffset(16, 14).addCuboid(2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F);
        this.field_20788.setTextureOffset(0, 10).addCuboid(-0.5F, 0.0F, -5.0F, 3.0F, 3.0F, 4.0F, 0.0F);
    }

    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.torso, this.rightBackLeg, this.leftBackLeg, this.rightFrontLeg, this.leftFrontLeg, this.tail, this.neck);
    }

    public void animateModel(T wolfEntity, float f, float g, float h) {
        this.torso.setPivot(0.0F, 14.0F, 2.0F);
        this.torso.pitch = 1.5707964F;
        this.neck.setPivot(-1.0F, 14.0F, -3.0F);
        this.neck.pitch = this.torso.pitch;
        this.tail.setPivot(-1.0F, 12.0F, 8.0F);
        this.rightBackLeg.setPivot(-2.5F, 16.0F, 7.0F);
        this.leftBackLeg.setPivot(0.5F, 16.0F, 7.0F);
        this.rightFrontLeg.setPivot(-2.5F, 16.0F, -4.0F);
        this.leftFrontLeg.setPivot(0.5F, 16.0F, -4.0F);
        this.rightBackLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
        this.leftBackLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
        this.rightFrontLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
        this.leftFrontLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
    }

    public void setAngles(T wolfEntity, float f, float g, float h, float i, float j) {
        this.head.pitch = j * 0.017453292F;
        this.head.yaw = i * 0.017453292F;
        this.tail.pitch = h;
    }
}
