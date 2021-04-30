	.text

	.globl	abs
	.p2align	2
	.type	abs,@function
abs:
.L0_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	sw	s0, 8(sp)
	mv	s0, a0
	addi	a0, zero, 4
	call	malloc
	sw	zero, 0(a0)
	slt	t4, zero, s0
	beqz	t4, .L0_2
	j	.L0_1
.L0_1:
	sw	s0, 0(a0)
	j	.L0_3
.L0_2:
	lw	t4, 0(sp)
	lw	t4, 0(t4)
	sub	t4, zero, s0
	sw	t4, 0(a0)
	j	.L0_3
.L0_3:
	lw	a0, 0(a0)
	lw	s0, 8(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	abs, .-abs
	.globl	main
	.p2align	2
	.type	main,@function
main:
.L1_0:
	addi	sp, sp, -12
	sw	ra, 4(sp)
	sw	s11, 0(sp)
	sw	s10, 8(sp)
	call	mx__init
	addi	a0, zero, 4
	call	malloc
	mv	s11, a0
	sw	zero, 0(s11)
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	lui	t4, %hi(i)
	sw	zero, %lo(i)(t4)
	j	.L1_1
.L1_1:
	lui	t4, %hi(i)
	lw	t5, %lo(i)(t4)
	addi	t4, zero, 5
	slt	t4, t5, t4
	beqz	t4, .L1_9
	j	.L1_2
.L1_2:
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	lui	t4, %hi(j)
	sw	zero, %lo(j)(t4)
	j	.L1_3
.L1_3:
	lui	t4, %hi(j)
	lw	t5, %lo(j)(t4)
	addi	t4, zero, 5
	slt	t4, t5, t4
	beqz	t4, .L1_8
	j	.L1_4
.L1_4:
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	call	mx__getInt
	lui	t4, %hi(n)
	sw	a0, %lo(n)(t4)
	lui	t4, %hi(n)
	lw	t4, %lo(n)(t4)
	addi	t4, t4, -1
	seqz	t4, t4
	beqz	t4, .L1_6
	j	.L1_5
.L1_5:
	lui	t4, %hi(r)
	lw	t4, %lo(r)(t4)
	lui	t4, %hi(i)
	lw	t5, %lo(i)(t4)
	lui	t4, %hi(r)
	sw	t5, %lo(r)(t4)
	lui	t4, %hi(c)
	lw	t4, %lo(c)(t4)
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	lui	t5, %hi(c)
	sw	t4, %lo(c)(t5)
	j	.L1_7
.L1_6:
	j	.L1_7
.L1_7:
	lui	t4, %hi(j)
	lw	t4, %lo(j)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(j)
	sw	t5, %lo(j)(t4)
	j	.L1_3
.L1_8:
	lui	t4, %hi(i)
	lw	t4, %lo(i)(t4)
	addi	t5, t4, 1
	lui	t4, %hi(i)
	sw	t5, %lo(i)(t4)
	j	.L1_1
.L1_9:
	lui	t4, %hi(r)
	lw	t4, %lo(r)(t4)
	addi	t5, zero, 2
	sub	a0, t5, t4
	call	abs
	mv	s10, a0
	lui	t4, %hi(c)
	lw	t5, %lo(c)(t4)
	addi	t4, zero, 2
	sub	a0, t4, t5
	call	abs
	add	a0, s10, a0
	call	mx__printInt
	sw	zero, 0(s11)
	lw	a0, 0(s11)
	lw	s11, 0(sp)
	lw	s10, 8(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 12
	ret
	.size	main, .-main
	.globl	mx__init
	.p2align	2
	.type	mx__init,@function
mx__init:
.L2_0:
	ret
	.size	mx__init, .-mx__init

	.section	.sdata,"aw",@progbits
	.global	r
	.p2align	2
	r:
	.word	0                       # 0
	.global	c
	.p2align	2
	c:
	.word	0                       # 0
	.global	i
	.p2align	2
	i:
	.word	0                       # 0
	.global	j
	.p2align	2
	j:
	.word	0                       # 0
	.global	n
	.p2align	2
	n:
	.word	0                       # 0
