// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modellustar_halo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "lustar_halo"), "main");
	private final ModelPart Head;

	public Modellustar_halo(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.0F, -11.0F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(2.0F, -11.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(-3.0F, -11.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-3.0F, -11.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_r1 = Head.addOrReplaceChild("Body_r1",
				CubeListBuilder.create().texOffs(10, 5).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -10.5F, 3.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Body_r2 = Head.addOrReplaceChild("Body_r2",
				CubeListBuilder.create().texOffs(10, 7).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -10.5F, 3.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition Body_r3 = Head.addOrReplaceChild("Body_r3",
				CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -10.5F, -3.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition Body_r4 = Head.addOrReplaceChild("Body_r4",
				CubeListBuilder.create().texOffs(10, 4).addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -10.5F, -3.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}