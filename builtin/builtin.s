	.text
	.file	"builtin.c"
	.globl	mx__print                 # -- Begin function mx__print
	.p2align	2
	.type	mx__print,@function
mx__print:                                # @mx__print
# %bb.0:
	lui	a1, %hi(.L.str)
	addi	a1, a1, %lo(.L.str)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end0:
	.size	mx__print, .Lfunc_end0-mx__print
                                        # -- End function
	.globl	mx__println               # -- Begin function mx__println
	.p2align	2
	.type	mx__println,@function
mx__println:                              # @mx__println
# %bb.0:
	tail	puts
.Lfunc_end1:
	.size	mx__println, .Lfunc_end1-mx__println
                                        # -- End function
	.globl	mx__printInt              # -- Begin function mx__printInt
	.p2align	2
	.type	mx__printInt,@function
mx__printInt:                             # @mx__printInt
# %bb.0:
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end2:
	.size	mx__printInt, .Lfunc_end2-mx__printInt
                                        # -- End function
	.globl	mx__printlnInt            # -- Begin function mx__printlnInt
	.p2align	2
	.type	mx__printlnInt,@function
mx__printlnInt:                           # @mx__printlnInt
# %bb.0:
	lui	a1, %hi(.L.str.3)
	addi	a1, a1, %lo(.L.str.3)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end3:
	.size	mx__printlnInt, .Lfunc_end3-mx__printlnInt
                                        # -- End function
	.globl	mx__getString             # -- Begin function mx__getString
	.p2align	2
	.type	mx__getString,@function
mx__getString:                            # @mx__getString
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	addi	a0, zero, 128
	call	malloc
	mv	s0, a0
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	mv	a1, s0
	call	scanf
	mv	a0, s0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	mx__getString, .Lfunc_end4-mx__getString
                                        # -- End function
	.globl	mx__getInt                # -- Begin function mx__getInt
	.p2align	2
	.type	mx__getInt,@function
mx__getInt:                               # @mx__getInt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	mx__getInt, .Lfunc_end5-mx__getInt
                                        # -- End function
	.globl	mx__toString              # -- Begin function mx__toString
	.p2align	2
	.type	mx__toString,@function
mx__toString:                             # @mx__toString
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	mv	s0, a0
	addi	a0, zero, 12
	call	malloc
	mv	s1, a0
	lui	a0, %hi(.L.str.2)
	addi	a1, a0, %lo(.L.str.2)
	mv	a0, s1
	mv	a2, s0
	call	sprintf
	mv	a0, s1
	lw	s1, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	mx__toString, .Lfunc_end6-mx__toString
                                        # -- End function
	.globl	mx__string_ord            # -- Begin function mx__string_ord
	.p2align	2
	.type	mx__string_ord,@function
mx__string_ord:                           # @mx__string_ord
# %bb.0:
	add	a0, a0, a1
	lbu	a0, 0(a0)
	ret
.Lfunc_end7:
	.size	mx__string_ord, .Lfunc_end7-mx__string_ord
                                        # -- End function
	.globl	mx__string_substring      # -- Begin function mx__string_substring
	.p2align	2
	.type	mx__string_substring,@function
mx__string_substring:                     # @mx__string_substring
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	s2, 0(sp)
	mv	s0, a1
	mv	s2, a0
	sub	s1, a2, a1
	addi	a0, s1, 1
	call	malloc
	add	a1, s2, s0
	mv	a2, s1
	lw	s2, 0(sp)
	lw	s1, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	memcpy
.Lfunc_end8:
	.size	mx__string_substring, .Lfunc_end8-mx__string_substring
                                        # -- End function
	.globl	mx__string_parseInt       # -- Begin function mx__string_parseInt
	.p2align	2
	.type	mx__string_parseInt,@function
mx__string_parseInt:                      # @mx__string_parseInt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 8
	call	sscanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	mx__string_parseInt, .Lfunc_end9-mx__string_parseInt
                                        # -- End function
	.globl	mx__string_length         # -- Begin function mx__string_length
	.p2align	2
	.type	mx__string_length,@function
mx__string_length:                        # @mx__string_length
# %bb.0:
	tail	strlen
.Lfunc_end10:
	.size	mx__string_length, .Lfunc_end10-mx__string_length
                                        # -- End function
	.globl	mx__string_add             # -- Begin function mx__string_add
	.p2align	2
	.type	mx__string_add,@function
mx__string_add:                            # @mx__string_add
# %bb.0:
	addi	sp, sp, -32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	sw	s2, 16(sp)
	sw	s3, 12(sp)
	mv	s2, a1
	mv	s3, a0
	call	strlen
	mv	s0, a0
	mv	a0, s2
	call	strlen
	add	a0, s0, a0
	addi	a0, a0, 1
	call	malloc
	mv	s1, a0
	mv	a1, s3
	mv	a2, s0
	call	memcpy
	mv	a0, s1
	mv	a1, s2
	lw	s3, 12(sp)
	lw	s2, 16(sp)
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	tail	strcat
.Lfunc_end11:
	.size	mx__string_add, .Lfunc_end11-mx__string_add
                                        # -- End function
	.globl	mx__string_eq              # -- Begin function mx__string_eq
	.p2align	2
	.type	mx__string_eq,@function
mx__string_eq:                             # @mx__string_eq
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	mx__string_eq, .Lfunc_end12-mx__string_eq
                                        # -- End function
	.globl	mx__string_ne              # -- Begin function mx__string_ne
	.p2align	2
	.type	mx__string_ne,@function
mx__string_ne:                             # @mx__string_ne
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	mx__string_ne, .Lfunc_end13-mx__string_ne
                                        # -- End function
	.globl	mx__string_lt              # -- Begin function mx__string_lt
	.p2align	2
	.type	mx__string_lt,@function
mx__string_lt:                             # @mx__string_lt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	mx__string_lt, .Lfunc_end14-mx__string_lt
                                        # -- End function
	.globl	mx__string_le              # -- Begin function mx__string_le
	.p2align	2
	.type	mx__string_le,@function
mx__string_le:                             # @mx__string_le
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	mx__string_le, .Lfunc_end15-mx__string_le
                                        # -- End function
	.globl	mx__string_gt              # -- Begin function mx__string_gt
	.p2align	2
	.type	mx__string_gt,@function
mx__string_gt:                             # @mx__string_gt
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	sgtz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end16:
	.size	mx__string_gt, .Lfunc_end16-mx__string_gt
                                        # -- End function
	.globl	mx__string_ge              # -- Begin function mx__string_ge
	.p2align	2
	.type	mx__string_ge,@function
mx__string_ge:                             # @mx__string_ge
# %bb.0:
	addi	sp, sp, -16
	sw	ra, 12(sp)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	mx__string_ge, .Lfunc_end17-mx__string_ge
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
