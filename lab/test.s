	.text

	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L0_0:
	ret
	.size	mx__init, .-mx__init
	.globl	wpp
	.p2align	2
	.type	wpp,@function
wpp:
.L1_0:
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	a0, t0, 1
	lui	t0, %hi(w)
	sw	a0, %lo(w)(t0)
	ret
	.size	wpp, .-wpp
	.globl	wppp
	.p2align	2
	.type	wppp,@function
wppp:
.L2_0:
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	a0, t0, 1
	lui	t0, %hi(w)
	sw	a0, %lo(w)(t0)
	ret
	.size	wppp, .-wppp
	.globl	wpppp
	.p2align	2
	.type	wpppp,@function
wpppp:
.L3_0:
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	t1, t0, 1
	lui	t0, %hi(w)
	sw	t1, %lo(w)(t0)
	lui	t0, %hi(w)
	lw	t0, %lo(w)(t0)
	addi	a0, t0, 1
	lui	t0, %hi(w)
	sw	a0, %lo(w)(t0)
	ret
	.size	wpppp, .-wpppp
	.globl	block
	.p2align	2
	.type	block,@function
block:
.L4_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	j	.L4_1
.L4_1:
	j	.L4_2
.L4_2:
	j	.L4_3
.L4_3:
	j	.L4_4
.L4_4:
	j	.L4_5
.L4_5:
	j	.L4_6
.L4_6:
	j	.L4_7
.L4_7:
	j	.L4_8
.L4_8:
	j	.L4_9
.L4_9:
	j	.L4_10
.L4_10:
	j	.L4_11
.L4_11:
	j	.L4_12
.L4_12:
	j	.L4_13
.L4_13:
	j	.L4_14
.L4_14:
	j	.L4_15
.L4_15:
	call	block
	j	.L4_16
.L4_16:
	j	.L4_17
.L4_17:
	j	.L4_18
.L4_18:
	j	.L4_19
.L4_19:
	j	.L4_20
.L4_20:
	j	.L4_21
.L4_21:
	j	.L4_22
.L4_22:
	j	.L4_23
.L4_23:
	j	.L4_24
.L4_24:
	j	.L4_25
.L4_25:
	j	.L4_26
.L4_26:
	j	.L4_27
.L4_27:
	j	.L4_28
.L4_28:
	j	.L4_29
.L4_29:
	j	.L4_30
.L4_30:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	block, .-block
	.globl	bblock
	.p2align	2
	.type	bblock,@function
bblock:
.L5_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	wpppp
	call	wpppp
	call	wpppp
	call	wpppp
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	call	bblock
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	bblock, .-bblock
	.globl	add1
	.p2align	2
	.type	add1,@function
add1:
.L6_0:
	addi	a0, a0, 1
	ret
	.size	add1, .-add1
	.globl	add2
	.p2align	2
	.type	add2,@function
add2:
.L7_0:
	addi	t0, a0, 1
	addi	a0, t0, 1
	ret
	.size	add2, .-add2
	.globl	add4
	.p2align	2
	.type	add4,@function
add4:
.L8_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add4, .-add4
	.globl	add8
	.p2align	2
	.type	add8,@function
add8:
.L9_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add8, .-add8
	.globl	add16
	.p2align	2
	.type	add16,@function
add16:
.L10_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add16, .-add16
	.globl	add32
	.p2align	2
	.type	add32,@function
add32:
.L11_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add32, .-add32
	.globl	add64
	.p2align	2
	.type	add64,@function
add64:
.L12_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add64, .-add64
	.globl	add128
	.p2align	2
	.type	add128,@function
add128:
.L13_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add128, .-add128
	.globl	add256
	.p2align	2
	.type	add256,@function
add256:
.L14_0:
	addi	t0, a0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	t0, t0, 1
	addi	a0, t0, 1
	ret
	.size	add256, .-add256
	.globl	add512
	.p2align	2
	.type	add512,@function
add512:
.L15_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add512, .-add512
	.globl	add1024
	.p2align	2
	.type	add1024,@function
add1024:
.L16_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add1024, .-add1024
	.globl	add2048
	.p2align	2
	.type	add2048,@function
add2048:
.L17_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add2048, .-add2048
	.globl	add4096
	.p2align	2
	.type	add4096,@function
add4096:
.L18_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add4096, .-add4096
	.globl	add8192
	.p2align	2
	.type	add8192,@function
add8192:
.L19_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add8192, .-add8192
	.globl	add16384
	.p2align	2
	.type	add16384,@function
add16384:
.L20_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add16384, .-add16384
	.globl	add32768
	.p2align	2
	.type	add32768,@function
add32768:
.L21_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add32768, .-add32768
	.globl	add65536
	.p2align	2
	.type	add65536,@function
add65536:
.L22_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	call	add256
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add65536, .-add65536
	.globl	add131072
	.p2align	2
	.type	add131072,@function
add131072:
.L23_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add65536
	call	add65536
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add131072, .-add131072
	.globl	add262144
	.p2align	2
	.type	add262144,@function
add262144:
.L24_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add262144, .-add262144
	.globl	add524288
	.p2align	2
	.type	add524288,@function
add524288:
.L25_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	call	add65536
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	add524288, .-add524288
	.globl	wP
	.p2align	2
	.type	wP,@function
wP:
.L26_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	sw	s9, 8(sp)
	sw	s10, 0(sp)
	addi	ra, zero, 3
	j	.L26_1
.L26_1:
	srai	t2, ra, 1
	addi	t0, zero, 2
	j	.L26_2
.L26_2:
	slt	t1, t0, t2
	beqz	t1, .L26_3
	j	.L26_4
.L26_3:
	addi	t2, zero, 1
	j	.L26_7
.L26_4:
	rem	t1, ra, t0
	addi	t1, t1, 0
	seqz	t1, t1
	beqz	t1, .L26_6
	j	.L26_5
.L26_5:
	addi	ra, ra, 1
	addi	t2, zero, 0
	j	.L26_7
.L26_6:
	addi	t0, t0, 1
	j	.L26_2
.L26_7:
	slt	t0, zero, ra
	beqz	t0, .L26_8
	j	.L26_9
.L26_8:
	addi	t0, zero, 0
	j	.L26_10
.L26_9:
	add	t1, ra, t2
	addi	t0, zero, 9
	rem	t0, t1, t0
	addi	t0, t0, 0
	seqz	t0, t0
	j	.L26_10
.L26_10:
	beqz	t0, .L26_12
	j	.L26_11
.L26_11:
	lui	ra, %hi(N)
	lw	s9, %lo(N)(ra)
	call	wpppp
	add	t0, s9, a0
	addi	ra, zero, 2
	rem	ra, t0, ra
	addi	ra, ra, 0
	seqz	ra, ra
	beqz	ra, .L26_14
	j	.L26_13
.L26_12:
	lui	t0, %hi(N)
	lw	t0, %lo(N)(t0)
	add	t1, t0, t2
	lui	t0, %hi(N)
	sw	t1, %lo(N)(t0)
	add	ra, ra, t2
	addi	ra, ra, 1
	j	.L26_1
.L26_13:
	lui	ra, %hi(N)
	lw	a0, %lo(N)(ra)
	call	add524288
	li	ra, 524288
	sub	ra, a0, ra
	addi	a0, ra, -4
	j	.L26_15
.L26_14:
	call	block
	call	block
	call	block
	call	block
	call	bblock
	j	.L26_15
.L26_15:
	lw	s9, 8(sp)
	lw	s10, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	wP, .-wP
	.globl	sanity_check
	.p2align	2
	.type	sanity_check,@function
sanity_check:
.L27_0:
	j	.L27_1
.L27_1:
	lui	ra, %hi(N)
	lw	ra, %lo(N)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(N)
	sw	t0, %lo(N)(ra)
	j	.L27_1
	.size	sanity_check, .-sanity_check
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L28_0:
	j	.L28_1
.L28_1:
	lui	ra, %hi(N)
	lw	ra, %lo(N)(ra)
	addi	t0, ra, 1
	lui	ra, %hi(N)
	sw	t0, %lo(N)(ra)
	j	.L28_1
	.size	main, .-main

	.section	.sdata,"aw",@progbits
	.global	w
	.p2align	2
	w:
	.word	0                       # 0
	.global	N
	.p2align	2
	N:
	.word	1                       # 1
