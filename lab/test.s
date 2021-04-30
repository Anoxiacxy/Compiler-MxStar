	.text

	.globl	jud
	.p2align	2
	.type	jud,@function
jud:
.L0_0:
	addi	sp, sp, -24
	sw	ra, 12(sp)
	sw	s11, 20(sp)
	sw	s0, 0(sp)
	sw	s1, 8(sp)
	sw	s2, 4(sp)
	sw	s6, 16(sp)
	mv	s0, a0
	addi	a0, zero, 1
	call	malloc
	mv	s1, a0
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	addi	a0, zero, 4
	call	malloc
	mv	s2, a0
	addi	a0, zero, 4
	call	malloc
	sw	zero, 0(a0)
	sw	zero, 0(s2)
	sw	zero, 0(s11)
	lw	t4, 0(s2)
	sw	zero, 0(s2)
	j	.L0_1
.L0_1:
	lw	t4, 0(s2)
	lui	t5, %hi(n)
	lw	t5, %lo(n)(t5)
	div	t5, t5, s0
	slt	t4, t4, t5
	beqz	t4, .L0_11
	j	.L0_2
.L0_2:
	sb	zero, 0(s1)
	lw	t4, 0(s11)
	sw	zero, 0(s11)
	j	.L0_3
.L0_3:
	lw	t5, 0(s11)
	addi	t4, s0, -1
	slt	t4, t5, t4
	beqz	t4, .L0_8
	j	.L0_4
.L0_4:
	lui	t4, %hi(a)
	lw	t4, %lo(a)(t4)
	lw	t5, 0(s2)
	mul	t5, t5, s0
	lw	t6, 0(s11)
	add	t5, t5, t6
	slli	t5, t5, 2
	add	t4, t4, t5
	lw	t5, 0(t4)
	lui	t4, %hi(a)
	lw	ra, %lo(a)(t4)
	lw	t4, 0(s2)
	mul	t4, t4, s0
	lw	t6, 0(s11)
	add	t4, t4, t6
	addi	t4, t4, 1
	slli	t4, t4, 2
	add	t4, ra, t4
	lw	t4, 0(t4)
	slt	t4, t4, t5
	beqz	t4, .L0_6
	j	.L0_5
.L0_5:
	lb	t4, 0(s1)
	addi	t4, zero, 1
	sb	t4, 0(s1)
	j	.L0_7
.L0_6:
	j	.L0_7
.L0_7:
	lw	t4, 0(s11)
	addi	t4, t4, 1
	sw	t4, 0(s11)
	j	.L0_3
.L0_8:
	lb	t4, 0(s1)
	xori	t4, t4, 1
	beqz	t4, .L0_10
	j	.L0_9
.L0_9:
	addi	t4, zero, 1
	sw	t4, 0(a0)
	j	.L0_12
.L0_10:
	lw	t4, 0(s2)
	addi	t4, t4, 1
	sw	t4, 0(s2)
	j	.L0_1
.L0_11:
	sw	zero, 0(a0)
	j	.L0_12
.L0_12:
	lw	a0, 0(a0)
	lw	s11, 20(sp)
	lw	s0, 0(sp)
	lw	s1, 8(sp)
	lw	s2, 4(sp)
	lw	s6, 16(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 24
	ret
	.size	jud, .-jud
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L1_0:
	addi	sp, sp, -12
	sw	ra, 0(sp)
	sw	s10, 4(sp)
	sw	s0, 8(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s0, a0
	sw	zero, 0(s0)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	call	mx__getInt
	lui	t4, %hi(n)
	sw	a0, %lo(n)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	sw	zero, %lo(i)(t4)
	j	.L1_1
.L1_1:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t5, %hi(n)
	lw	t5, %lo(n)(t5)
	slt	t4, t4, t5
	beqz	t4, .L1_3
	j	.L1_2
.L1_2:
	lui	t4, %hi(a)
	lw	t5, %lo(a)(t4)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slli	t4, t4, 2
	add	s10, t5, t4
	lw	t4, 0(s10)
	call	mx__getInt
	sw	a0, 0(s10)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	addi	t4, t4, 1
	lui	t5, %hi(i)
	sw	t4, %lo(i)(t5)
	j	.L1_1
.L1_3:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	lui	t5, %hi(i)
	sw	t4, %lo(i)(t5)
	j	.L1_4
.L1_4:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	slt	t4, zero, t4
	beqz	t4, .L1_8
	j	.L1_5
.L1_5:
	lui	t4, %hi(i)
	lw	a0, %lo(i)(t4)
	call	jud
	slt	t4, zero, a0
	beqz	t4, .L1_7
	j	.L1_6
.L1_6:
	lui	t4, %hi(i)
	lw	a0, %lo(i)(t4)
	call	mx__toString
	call	mx__print
	sw	zero, 0(s0)
	j	.L1_9
.L1_7:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	lw	t5, %lo(i)(t4)
	addi	t4, zero, 2
	div	t4, t5, t4
	lui	t5, %hi(i)
	sw	t4, %lo(i)(t5)
	j	.L1_4
.L1_8:
	sw	zero, 0(s0)
	j	.L1_9
.L1_9:
	lw	a0, 0(s0)
	lw	s10, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 12
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L2_0:
	addi	sp, sp, -4
	sw	ra, 0(sp)
	addi	t4, zero, 4
	addi	t5, zero, 20
	mul	t4, t4, t5
	addi	a0, t4, 4
	call	malloc
	addi	t4, zero, 20
	sw	t4, 0(a0)
	addi	t4, a0, 4
	lui	t5, %hi(a)
	sw	t4, %lo(a)(t5)
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
	.global	n
	.p2align	2
	n:
	.word	0                       # 0
