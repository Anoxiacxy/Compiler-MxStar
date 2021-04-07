	.text
	.attribute	4, 16
	.attribute	5, "rv32i2p0_m2p0"
	.file	"builtin.c"
	.globl	mx__print                       # -- Begin function mx__print
	.p2align	2
	.type	mx__print,@function
mx__print:                              # @mx__print
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a1, %hi(.L.str)
	addi	a1, a1, %lo(.L.str)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	printf
.Lfunc_end0:
	.size	mx__print, .Lfunc_end0-mx__print
	.cfi_endproc
                                        # -- End function
	.globl	mx__println                     # -- Begin function mx__println
	.p2align	2
	.type	mx__println,@function
mx__println:                            # @mx__println
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	puts
.Lfunc_end1:
	.size	mx__println, .Lfunc_end1-mx__println
	.cfi_endproc
                                        # -- End function
	.globl	mx__printInt                    # -- Begin function mx__printInt
	.p2align	2
	.type	mx__printInt,@function
mx__printInt:                           # @mx__printInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	printf
.Lfunc_end2:
	.size	mx__printInt, .Lfunc_end2-mx__printInt
	.cfi_endproc
                                        # -- End function
	.globl	mx__printlnInt                  # -- Begin function mx__printlnInt
	.p2align	2
	.type	mx__printlnInt,@function
mx__printlnInt:                         # @mx__printlnInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a1, %hi(.L.str.3)
	addi	a1, a1, %lo(.L.str.3)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	printf
.Lfunc_end3:
	.size	mx__printlnInt, .Lfunc_end3-mx__printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	mx__getString                   # -- Begin function mx__getString
	.p2align	2
	.type	mx__getString,@function
mx__getString:                          # @mx__getString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	addi	a0, zero, 1024
	mv	a1, zero
	call	malloc
	mv	s1, a0
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	mv	a1, s1
	call	scanf
	mv	a0, s1
	lw	s1, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	mx__getString, .Lfunc_end4-mx__getString
	.cfi_endproc
                                        # -- End function
	.globl	mx__getInt                      # -- Begin function mx__getInt
	.p2align	2
	.type	mx__getInt,@function
mx__getInt:                             # @mx__getInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, s0, -12
	call	scanf
	lw	a0, -12(s0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	mx__getInt, .Lfunc_end5-mx__getInt
	.cfi_endproc
                                        # -- End function
	.globl	mx__toString                    # -- Begin function mx__toString
	.p2align	2
	.type	mx__toString,@function
mx__toString:                           # @mx__toString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	s2, 0(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	mv	s2, a0
	addi	a0, zero, 16
	mv	a1, zero
	call	malloc
	mv	s1, a0
	lui	a0, %hi(.L.str.2)
	addi	a4, a0, %lo(.L.str.2)
	addi	a2, zero, 16
	mv	a0, s1
	mv	a1, zero
	mv	a3, zero
	mv	a5, s2
	call	__sprintf_chk
	mv	a0, s1
	lw	s2, 0(sp)
	lw	s1, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	mx__toString, .Lfunc_end6-mx__toString
	.cfi_endproc
                                        # -- End function
	.globl	mx__malloc                      # -- Begin function mx__malloc
	.p2align	2
	.type	mx__malloc,@function
mx__malloc:                             # @mx__malloc
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	srai	a1, a0, 31
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	malloc
.Lfunc_end7:
	.size	mx__malloc, .Lfunc_end7-mx__malloc
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_add                     # -- Begin function mx__str_add
	.p2align	2
	.type	mx__str_add,@function
mx__str_add:                            # @mx__str_add
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	sw	s2, 16(sp)
	sw	s3, 12(sp)
	sw	s4, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	.cfi_offset s3, -20
	.cfi_offset s4, -24
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	mv	s2, a1
	mv	s4, a0
	call	strlen
	mv	s3, a0
	mv	s1, a1
	mv	a0, s2
	call	strlen
	add	a1, a1, s1
	add	a2, a0, s3
	sltu	a0, a2, a0
	add	a1, a1, a0
	mv	a0, a2
	call	malloc
	mv	s1, a0
	mv	a1, s4
	call	strcpy
	mv	a0, s1
	mv	a1, s2
	call	strcat
	mv	a0, s1
	lw	s4, 8(sp)
	lw	s3, 12(sp)
	lw	s2, 16(sp)
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end8:
	.size	mx__str_add, .Lfunc_end8-mx__str_add
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_lt                      # -- Begin function mx__str_lt
	.p2align	2
	.type	mx__str_lt,@function
mx__str_lt:                             # @mx__str_lt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	srli	a0, a0, 31
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	mx__str_lt, .Lfunc_end9-mx__str_lt
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_gt                      # -- Begin function mx__str_gt
	.p2align	2
	.type	mx__str_gt,@function
mx__str_gt:                             # @mx__str_gt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	sgtz	a0, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end10:
	.size	mx__str_gt, .Lfunc_end10-mx__str_gt
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_le                      # -- Begin function mx__str_le
	.p2align	2
	.type	mx__str_le,@function
mx__str_le:                             # @mx__str_le
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	slti	a0, a0, 1
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end11:
	.size	mx__str_le, .Lfunc_end11-mx__str_le
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_ge                      # -- Begin function mx__str_ge
	.p2align	2
	.type	mx__str_ge,@function
mx__str_ge:                             # @mx__str_ge
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	mx__str_ge, .Lfunc_end12-mx__str_ge
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_eq                      # -- Begin function mx__str_eq
	.p2align	2
	.type	mx__str_eq,@function
mx__str_eq:                             # @mx__str_eq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	seqz	a0, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	mx__str_eq, .Lfunc_end13-mx__str_eq
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_ne                      # -- Begin function mx__str_ne
	.p2align	2
	.type	mx__str_ne,@function
mx__str_ne:                             # @mx__str_ne
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strcmp
	snez	a0, a0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	mx__str_ne, .Lfunc_end14-mx__str_ne
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_length                  # -- Begin function mx__str_length
	.p2align	2
	.type	mx__str_length,@function
mx__str_length:                         # @mx__str_length
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	call	strlen
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	mx__str_length, .Lfunc_end15-mx__str_length
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_substring               # -- Begin function mx__str_substring
	.p2align	2
	.type	mx__str_substring,@function
mx__str_substring:                      # @mx__str_substring
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	sw	s2, 16(sp)
	sw	s3, 12(sp)
	sw	s4, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	.cfi_offset s3, -20
	.cfi_offset s4, -24
	addi	s0, sp, 32
	.cfi_def_cfa s0, 0
	mv	s3, a1
	mv	s2, a0
	sub	s4, a2, a1
	addi	a0, s4, 1
	srai	a1, a0, 31
	call	malloc
	mv	s1, a0
	add	a1, s2, s3
	mv	a2, s4
	call	memcpy
	add	a0, s1, s4
	sb	zero, 0(a0)
	mv	a0, s1
	lw	s4, 8(sp)
	lw	s3, 12(sp)
	lw	s2, 16(sp)
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	ret
.Lfunc_end16:
	.size	mx__str_substring, .Lfunc_end16-mx__str_substring
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_parseInt                # -- Begin function mx__str_parseInt
	.p2align	2
	.type	mx__str_parseInt,@function
mx__str_parseInt:                       # @mx__str_parseInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, s0, -12
	call	sscanf
	lw	a0, -12(s0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	mx__str_parseInt, .Lfunc_end17-mx__str_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	mx__str_ord                     # -- Begin function mx__str_ord
	.p2align	2
	.type	mx__str_ord,@function
mx__str_ord:                            # @mx__str_ord
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	s0, sp, 16
	.cfi_def_cfa s0, 0
	add	a0, a0, a1
	lb	a0, 0(a0)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end18:
	.size	mx__str_ord, .Lfunc_end18-mx__str_ord
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object                  # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.2,@object                # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object                # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 11.1.0"
	.section	".note.GNU-stack","",@progbits
