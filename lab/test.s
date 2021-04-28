	.text

	.globl	main
	.p2align	2
	.type	main,@function
main:
.L0_0:
	addi	sp, sp, -8
	sw	ra, 4(sp)
	sw	s4, 0(sp)
	call	mx__init
	lui	t4, %hi(m)
	lw	t4, %lo(m)(t4)
	call	mx__getInt
	lui	t4, %hi(m)
	sw	a0, %lo(m)(t4)
	lui	t4, %hi(k)
	lw	t4, %lo(k)(t4)
	call	mx__getInt
	lui	t4, %hi(k)
	sw	a0, %lo(k)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	sw	zero, %lo(i)(t4)
	j	.L0_1
.L0_1:
	lui	t4, %hi(i)
	lw	t5, %lo(i)(t4)
	lui	t4, %hi(m)
	lw	t4, %lo(m)(t4)
	slt	t4, t5, t4
	beqz	t4, .L0_4
	j	.L0_2
.L0_2:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lui	t5, %hi(i)
	lw	t5, %lo(i)(t5)
	slli	t5, t5, 2
	add	s4, t4, t5
	lw	t4, 0(s4)
	call	mx__getInt
	sw	a0, 0(s4)
	j	.L0_3
.L0_3:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(i)
	sw	t5, %lo(i)(t4)
	j	.L0_1
.L0_4:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	sw	zero, %lo(i)(t4)
	j	.L0_5
.L0_5:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	lui	t5, %hi(a)
	lw	t6, %lo(a)(t5)
	lui	t5, %hi(k)
	lw	t5, %lo(k)(t5)
	addi	t5, t5, -1
	slli	t5, t5, 2
	add	t5, t6, t5
	lw	t5, 0(t5)
	slt	t4, t4, t5
	xori	t4, t4, 1
	beqz	t4, .L0_7
	j	.L0_8
.L0_6:
	addi	t4, zero, 0
	j	.L0_9
.L0_7:
	addi	t4, zero, 0
	j	.L0_9
.L0_8:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slli	t4, t4, 2
	add	t4, t5, t4
	lw	t4, 0(t4)
	slt	t4, zero, t4
	j	.L0_9
.L0_9:
	beqz	t4, .L0_11
	j	.L0_12
.L0_10:
	addi	t4, zero, 0
	j	.L0_13
.L0_11:
	addi	t4, zero, 0
	j	.L0_13
.L0_12:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t5, %hi(m)
	lw	t5, %lo(m)(t5)
	slt	t4, t4, t5
	j	.L0_13
.L0_13:
	beqz	t4, .L0_16
	j	.L0_14
.L0_14:
	j	.L0_15
.L0_15:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(i)
	sw	t5, %lo(i)(t4)
	j	.L0_5
.L0_16:
	lui	t4, %hi(i)
	lw	a0, %lo(i)(t4)
	call	mx__printInt
	j	.L0_17
.L0_17:
	addi	a0, zero, 0
	lw	s4, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 8
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L1_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	t4, zero, 4
	addi	t5, zero, 50
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 50
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(a)
	sw	t4, %lo(a)(t5)
	j	.L1_1
.L1_1:
	lw	ra, 0(sp)
	addi	sp, sp, 4
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.global	a
	.p2align	2
	a:
	.word	0                       # 0
	.global	i
	.p2align	2
	i:
	.word	0                       # 0
	.global	k
	.p2align	2
	k:
	.word	0                       # 0
	.global	m
	.p2align	2
	m:
	.word	0                       # 0
